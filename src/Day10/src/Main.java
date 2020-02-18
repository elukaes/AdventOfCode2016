package Day10.src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static Pattern valuePattern = Pattern.compile("value (\\d+) goes to bot (\\d+)");
    private static Pattern botPattern = Pattern.compile("bot (\\d+) gives low to (\\w+) (\\d+) and high to (\\w+) (\\d+)");
    public static void main(String[] args) throws IOException {
        List<String> inputValue = new LinkedList<>();
        List<String> inputBot = new LinkedList<>();
        List<Bot> bots = new LinkedList<>();
        List<Output> outputs = new LinkedList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(
                "C:\\Users\\ja\\Desktop\\Programowanie\\Java\\AdventOfCode2016\\src\\Day10\\input.txt"))) {
            while (true) {
                String line = bufferedReader.readLine(); //read line from file
                if (line == null) {
                    break;
                }
                if(line.contains("value")) { //divide input for 2 lists(one for only add bots and second for operations on bots)
                    inputValue.add(line);
                }
                else inputBot.add(line);
            }
        }
        for(String line: inputValue) { //add bots
                operationsOnValue(line, bots);
        }
        //int loops = 0;
        while(!inputBot.isEmpty()) { //operations on bots
            Bot botWith2Values = findBotWith2Values(bots);
            int lowestValue = botWith2Values.findLowestValue();
            int highestValue = botWith2Values.findHighestValue();
            int nbOfLow = 0, nbOfHigh = 0, remove = 0;
            String typeLow = "", typeHigh = "";
            if(lowestValue == 17 && highestValue == 61) {//find answer to task1
                System.out.println(botWith2Values.getNumber());
            }
            for(int i=0; i<inputBot.size(); i++) {
                Matcher matcher = botPattern.matcher(inputBot.get(i)); matcher.matches();
                if(botWith2Values.getNumber() == Integer.parseInt(matcher.group(1))) {
                    nbOfLow = Integer.parseInt(matcher.group(3));
                    nbOfHigh = Integer.parseInt(matcher.group(5));
                    typeLow = matcher.group(2);
                    typeHigh = matcher.group(4);
                    remove = i;
                    //loops++;
                    break;
                }
            }
            if(typeLow.equals("output")) {
                operationsOnOutput(nbOfLow, lowestValue, outputs);
            }
            if(typeHigh.equals("output")) {
                operationsOnOutput(nbOfHigh, highestValue, outputs);
            }
            boolean isRelayLowValue = false;
            boolean isRelayHighValue = false;
            for(int i=0; i<bots.size(); i++) {
                if(bots.get(i).getNumber() == nbOfLow && typeLow.equals("bot")) {
                    bots.get(i).addValue(lowestValue);
                    botWith2Values.removeValue(lowestValue);
                    isRelayLowValue = true;
                }
                if(bots.get(i).getNumber() == nbOfHigh && typeHigh.equals("bot")) {
                    bots.get(i).addValue(highestValue);
                    botWith2Values.removeValue(highestValue);
                    isRelayHighValue = true;
                }
            }
            if(!isRelayLowValue) {
                bots.add(new Bot(nbOfLow));
                bots.get(bots.size()-1).addValue(lowestValue);
                botWith2Values.removeValue(lowestValue);
            }
            if(!isRelayHighValue) {
                bots.add(new Bot(nbOfHigh));
                bots.get(bots.size()-1).addValue(highestValue);
                botWith2Values.removeValue(highestValue);
            }
            inputBot.remove(remove);
        }
        int result = 1;
        for(int i=0; i<outputs.size(); i++) {
            if(outputs.get(i).getNumber() == 0)
                result *= outputs.get(i).getValue(0);
            if(outputs.get(i).getNumber() == 1)
                result *= outputs.get(i).getValue(0);
            if(outputs.get(i).getNumber() == 2)
                result *= outputs.get(i).getValue(0);
        }
        System.out.println(result);
    }

    public static void operationsOnValue(String line, List<Bot> bots) {
        Matcher matcher = valuePattern.matcher(line);
        matcher.matches();
        int value = Integer.parseInt(matcher.group(1)); //less code
        int numberOfBot = Integer.parseInt(matcher.group(2));
        boolean isFoundBot = false; //variable to check if Bot is existing
        for(int i=0; i<bots.size(); i++) { //find existing Bot
            if(bots.get(i).getNumber() == numberOfBot) {
                bots.get(i).addValue(value);
                isFoundBot = true;
            }
        }
        if(!isFoundBot) { //create new Bot
            bots.add(new Bot(numberOfBot));
            bots.get(bots.size()-1).addValue(value);
        }
    }

    public static void operationsOnOutput(int nbOutput, int value, List<Output> outputs) {
        boolean isFoundOutput = false;
        for(int i=0; i<outputs.size(); i++) {
            if(outputs.get(i).getNumber() == nbOutput) {
                outputs.get(i).addValue(value);
                isFoundOutput = true;
            }
        }
        if(!isFoundOutput) {
            outputs.add(new Output(nbOutput));
            outputs.get(outputs.size() - 1).addValue(value);
        }
    }

    private static Bot findBotWith2Values(List<Bot> bots) {
        Bot botWith2Values = null;
        for(int i=0; i<bots.size(); i++) {
            if(bots.get(i).getAmountOfValues() == 2) {
                botWith2Values = bots.get(i);
            }
        }
        return botWith2Values;
    }
}