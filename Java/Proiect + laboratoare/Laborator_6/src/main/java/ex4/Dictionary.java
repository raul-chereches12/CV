package ex4;

import java.util.*;

public class Dictionary {

    private HashMap<Word, Definition> dictionary = new HashMap<Word, Definition>();


    public void addWord(Word w, Definition d) {
        dictionary.put(w, d);
    }

    public void getDefinition(Word w) {

        System.out.println(dictionary.get(w).getDescription());
//int i=0;
//int increment = 0;
//        for (Word key : dictionary.keySet()) {
//            i++;
//
//            if(key.getName().equals(string))
//                increment=i;
//
//        }
//i=0;
//        for (Definition definition : dictionary.values()) {
//            i++;
//            if(i==increment)
//                return definition.getDescription();
//        }
//return null;
    }


    public void getAllWords(){
        Set<Word> set = dictionary.keySet();

        System.out.println(Arrays.asList(set.toString()));

    }

    public void getAllDefinitions()
    {
Collection<Definition> definitions=dictionary.values();
        System.out.println(definitions);

    }



}
