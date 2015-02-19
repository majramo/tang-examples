package com.talios.cucumberng;

import gherkin.formatter.Formatter;
import gherkin.formatter.NiceAppendable;
import gherkin.formatter.Reporter;
import gherkin.formatter.model.*;
import org.testng.ITestResult;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import static org.testng.Reporter.log;

public class CucumberTestNgFormatter implements Formatter, Reporter {

    private final NiceAppendable out;

    private List<Result> results;

    private AtomicInteger failureCount = new AtomicInteger(0);
    private AtomicInteger skipCount = new AtomicInteger(0);
    private AtomicInteger passCount = new AtomicInteger(0);

    private LinkedList<Step> steps = new LinkedList<Step>();

    public CucumberTestNgFormatter(Appendable appendable) {
        out = new NiceAppendable(appendable);
    }

    public List<Result> getResults() {
        return results;
    }

    public AtomicInteger getFailureCount() {
        return failureCount;
    }

    public AtomicInteger getSkipCount() {
        return skipCount;
    }

    public AtomicInteger getPassCount() {
        return passCount;
    }

    public void setCurrentTestNgResult(ITestResult tr) {
        org.testng.Reporter.setCurrentTestResult(tr);
    }

    @Override
    public void uri(String uri) {
        reportLog("Feature File: " + uri );
    }

    @Override
    public void feature(Feature feature) {
        reportLog("Feature: " + feature.getName());
    }

    @Override
    public void background(Background background) {
    }

    @Override
    public void scenario(Scenario scenario) {
        reportLog("Scenario: " + scenario.getName());
    }

    @Override
    public void scenarioOutline(ScenarioOutline scenarioOutline) {
        reportLog("Scenario Outline: " + scenarioOutline.getName());
    }

    @Override
    public void examples(Examples examples) {
    }

    @Override
    public void step(Step step) {
        steps.add(step); //CHEATING…cache the steps
    }

    @Override
    public void eof() {
    }

    @Override
    public void syntaxError(String s, String s2, List<String> strings, String s3, Integer integer) {
    }

    @Override
    public void done() {
        steps.clear();
    }

    @Override
    public void close() {
        out.close();
    }

    @Override
    public void result(Result result) {
        //addTestNgAttribute(RESULTS, result);
        String timing = result.getDuration() != null ?
                " : " + (Math.round(result.getDuration() / 1000000000f * 100f) / 100f) + "s" : "";
        Step step;
        if (steps.isEmpty()) {
            step = new Step(null, "MISMATCH BETWEEN STEPS AND RESULTS", "", 0, null, null);
        } else {
            step = steps.pop();
        }
        reportLog("Result " + step.getKeyword() + " " + step.getName() +
                " (" + result.getStatus() + timing + ")</div>");

        if (Result.FAILED.equals(result)) {
            ITestResult tr = org.testng.Reporter.getCurrentTestResult();
            tr.setThrowable(result.getError());
            tr.setStatus(ITestResult.FAILURE);
            failureCount.incrementAndGet();
        } else if (Result.SKIPPED.equals(result)) {
            ITestResult tr = org.testng.Reporter.getCurrentTestResult();
            tr.setThrowable(result.getError());
            tr.setStatus(ITestResult.SKIP);
            skipCount.incrementAndGet();
        } else if (Result.UNDEFINED.equals(result)) {
            ITestResult tr = org.testng.Reporter.getCurrentTestResult();
            tr.setThrowable(result.getError());
            tr.setStatus(ITestResult.FAILURE);
            failureCount.incrementAndGet();
        } else {
            passCount.incrementAndGet();
        }
    }

    @Override
    public void before(Match match, Result result) {
    }

    @Override
    public void after(Match match, Result result) {
    }

    @Override
    public void write(String s) {
    }

    @Override
    public void match(Match match) {
    }

    @Override
    public void embedding(String s, byte[] bytes) {
	}
    private void reportLog (String message) {
        log("<BR>" + message);
    }

}
