package run

import java.util.zip.ZipException
import java.util.zip.ZipFile

public class JarFinder {
    static void main(args) {
        ArrayList<String> featureTests = findFeature("./lib", "feature")
        println featureTests.toString()

    }

    static ArrayList<String> findFeature(String root = "", String search = "") {
        String rootDir = root ? root : "."
        String fileToFind = root && search != "" ? search : "class"
        List<String> featureTests = new ArrayList<String>();

        int numMatchingItems = 0
        File dir = new File(root)
        dir.eachFileRecurse
                { file ->
                    if (file.isFile() && file.name.equals("vem-common-0.0.4-SNAPSHOT.jar")) {
                        try {
                            println file
                            def zip = new ZipFile(file)
                            def entries = zip.entries()
                            entries.findAll{it.toString().contains("resource")}.each
                                    { entry ->
                                        if (entry.name.contains(search)) {
                                            println "\t${entry.name}"
                                             featureTests.add(entry.name)
                                            numMatchingItems++
                                        }
                                    }
                        }
                        catch (ZipException zipEx) {
                            println "Unable to open file ${file.name}"
                        }
                    }
                }
        return featureTests

        println "${numMatchingItems} matches found!"
    }
}

