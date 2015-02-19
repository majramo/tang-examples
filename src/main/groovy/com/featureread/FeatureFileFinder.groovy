package com.featureread

public class FeatureFileFinder {

    public ArrayList<String>  findFeatrure(String root = "", String search = "") {
        List<String> featureTests = new ArrayList<String>();

        int numMatchingItems = 0
        File dir = new File(root)
        dir.eachFileRecurse
                { file ->
                    if (file.isFile() && file.name.equals("vem-common-0.0.4-SNAPSHOT.jar")) {
                        try {
                            println file
                            def entries = file.entries()
                            entries.findAll{it.toString().contains("resource.*feature")}.each
                                    { entry ->
                                        if (entry.name.contains(search)) {
                                            println "\t${entry.name}"
                                             featureTests.add(entry.name)
                                            numMatchingItems++
                                        }
                                    }
                        }
                        catch (e) {
                            println "Unable to open file ${file.name}"
                        }
                    }
                }
        return featureTests

        println "${numMatchingItems} matches found!"
}
}
