package graphs;

import lists.Queue;

import java.io.File;

public class BreadthFirstSearch {
    private static Queue<File> searchList = new Queue<>();

    public static String search(String root, String target) {
        searchList.enqueue(new File(root));

        File current = null;

        // continue until searchList is empty
        do {
            current = searchList.dequeue();

            if (current != null) {
                System.out.println("Searching..." + current);

                // determine file name
                String file = current.toString(); // file path to String
                file = file.substring(file.lastIndexOf("/") + 1); // remove everything before the final /

                // target found
                if (file.equals(target)) {
                    return current.toString();
                }

                // add subDirectories to search
                File[] sub_dirs = current.listFiles();


                if (sub_dirs != null) {
                    for (File f : sub_dirs) {
                        searchList.enqueue(f);
                    }
                }
            }
        } while (current != null);

        // default case
        return "not found";
    }

}
