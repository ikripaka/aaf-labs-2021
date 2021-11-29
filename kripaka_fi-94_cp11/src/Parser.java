import java.util.Locale;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static final Pattern INFO_INSIDE_BRACKETS = Pattern.compile("\\(([^{}()]*)\\)");
    private static final Pattern CREATE = Pattern.compile("(?i)create");
    private static final Pattern ONLY_WORDS = Pattern.compile("\\w*[^ (),;]");
    private static final Pattern INSERT = Pattern.compile("(?i)insert");
    private static final Pattern CONTAINS = Pattern.compile("(?i)contains");
    private static final Pattern SEARCH = Pattern.compile("(?i)search");
    private static final Pattern WHERE = Pattern.compile("(?i)where");
    private static final Pattern INSIDE = Pattern.compile("(?i)inside");
    private static final Pattern NN = Pattern.compile("(?i)nn");
    private static final Pattern LEFT_OF = Pattern.compile("(?i)left_of");
    private static final Pattern NUMBER = Pattern.compile("[0-9]+");

    private String[][] parsedCommands;


    public boolean parse(String line) {
        try {
            StringTokenizer tokenizer = new StringTokenizer(line, ";", false);
            Matcher match;
            parsedCommands = new String[tokenizer.countTokens()][];
            for (int i = 0; tokenizer.hasMoreTokens(); i++) {
                String token = tokenizer.nextToken();

                if (CREATE.matcher(String.valueOf(token)).find()) {
                    parsedCommands[i] = new String[2];
                    match = ONLY_WORDS.matcher(token);
                    if (!match.find() || !CREATE.matcher(match.group()).matches()) {
                        throw new IllegalArgumentException();
                    }
                    parsedCommands[i][0] = match.group().toUpperCase();

                    if (!match.find()) {
                        throw new IllegalArgumentException();
                    }
                    parsedCommands[i][1] = match.group();

                } else if (INSERT.matcher(String.valueOf(token)).find()) {
                    parsedCommands[i] = new String[4];
                    match = ONLY_WORDS.matcher(token);

                    if (!match.find() || !INSERT.matcher(match.group()).matches()) {
                        throw new IllegalArgumentException("no type identification");
                    }
                    parsedCommands[i][0] = match.group().toUpperCase();

                    if (!match.find()) {
                        throw new IllegalArgumentException("no group argument");
                    }
                    parsedCommands[i][1] = match.group();

                    match = INFO_INSIDE_BRACKETS.matcher(token);
                    if (!match.find()) {
                        throw new IllegalArgumentException("incorrect point");
                    }
                    String[] point = match.group().replaceAll("(\\(|\\)| )", "").split(",");
                    parsedCommands[i][2] = point[0];
                    parsedCommands[i][3] = point[1];

                } else if (CONTAINS.matcher(String.valueOf(token)).find()) {
                    parsedCommands[i] = new String[4];
                    match = ONLY_WORDS.matcher(token);

                    if (!match.find() || !CONTAINS.matcher(match.group()).matches()) {
                        throw new IllegalArgumentException("no type identification");
                    }
                    parsedCommands[i][0] = match.group().toUpperCase();

                    if (!match.find()) {
                        throw new IllegalArgumentException("no group argument");
                    }
                    parsedCommands[i][1] = match.group();

                    match = INFO_INSIDE_BRACKETS.matcher(token);
                    if (!match.find()) {
                        throw new IllegalArgumentException("incorrect point");
                    }
                    String[] point = match.group().replaceAll("(\\(|\\)| )", "").split(",");
                    parsedCommands[i][2] = point[0];
                    parsedCommands[i][3] = point[1];
                } else if (SEARCH.matcher(String.valueOf(token)).find()) {
                    if (WHERE.matcher(String.valueOf(token)).find()) {
                        if (INSIDE.matcher(String.valueOf(token)).find()) {
                            parsedCommands[i] = new String[8];

                            match = ONLY_WORDS.matcher(token);
                            if (!match.find() || !SEARCH.matcher(match.group()).matches()) {
                                throw new IllegalArgumentException();
                            }
                            parsedCommands[i][0] = match.group().toUpperCase();

                            if (!match.find()) {
                                throw new IllegalArgumentException();
                            }
                            parsedCommands[i][1] = match.group();

                            if(!match.find() || !WHERE.matcher(match.group()).matches()){
                                throw new IllegalArgumentException();
                            }
                            parsedCommands[i][2] = match.group().toUpperCase();

                            if(!match.find() || !INSIDE.matcher(match.group()).matches()){
                                throw new IllegalArgumentException();
                            }
                            parsedCommands[i][3] = match.group().toUpperCase();

                            match = INFO_INSIDE_BRACKETS.matcher(token);
                            if (!match.find()) {
                                throw new IllegalArgumentException("incorrect point");
                            }
                            String[] point1 = match.group().replaceAll("(\\(|\\)| )", "").split(",");
                            parsedCommands[i][4] = point1[0];
                            parsedCommands[i][5] = point1[1];

                            if (!match.find()) {
                                throw new IllegalArgumentException("incorrect point");
                            }
                            String[] point2 = match.group().replaceAll("(\\(|\\)| )", "").split(",");
                            parsedCommands[i][6] = point2[0];
                            parsedCommands[i][7] = point2[1];

                        } else if (NN.matcher(String.valueOf(token)).find()) {
                            parsedCommands[i] = new String[6];

                            match = ONLY_WORDS.matcher(token);
                            if (!match.find() || !SEARCH.matcher(match.group()).matches()) {
                                throw new IllegalArgumentException();
                            }
                            parsedCommands[i][0] = match.group().toUpperCase();

                            if (!match.find()) {
                                throw new IllegalArgumentException();
                            }
                            parsedCommands[i][1] = match.group();

                            if(!match.find() || !WHERE.matcher(match.group()).matches()){
                                throw new IllegalArgumentException();
                            }
                            parsedCommands[i][2] = match.group().toUpperCase();

                            if(!match.find() || !NN.matcher(match.group()).matches()){
                                throw new IllegalArgumentException();
                            }
                            parsedCommands[i][3] = match.group().toUpperCase();

                            match = INFO_INSIDE_BRACKETS.matcher(token);
                            if (!match.find()) {
                                throw new IllegalArgumentException("incorrect point");
                            }
                            String[] point = match.group().replaceAll("(\\(|\\)| )", "").split(",");
                            parsedCommands[i][4] = point[0];
                            parsedCommands[i][5] = point[1];

                        } else if (LEFT_OF.matcher(String.valueOf(token)).find()) {
                            parsedCommands[i] = new String[5];

                            match = ONLY_WORDS.matcher(token);
                            if (!match.find() || !SEARCH.matcher(match.group()).matches()) {
                                throw new IllegalArgumentException();
                            }
                            parsedCommands[i][0] = match.group().toUpperCase();

                            if (!match.find()) {
                                throw new IllegalArgumentException();
                            }
                            parsedCommands[i][1] = match.group();

                            if(!match.find() || !WHERE.matcher(match.group()).matches()){
                                throw new IllegalArgumentException();
                            }
                            parsedCommands[i][2] = match.group().toUpperCase();

                            if(!match.find() || !LEFT_OF.matcher(match.group()).matches()){
                                throw new IllegalArgumentException();
                            }
                            parsedCommands[i][3] = match.group().toUpperCase();

                            if(!match.find() || !NUMBER.matcher(match.group()).matches()){
                                throw new IllegalArgumentException("incorrect number");
                            }
                            parsedCommands[i][4] = match.group();
                        }
                    } else {
                        parsedCommands[i] = new String[2];
                        match = ONLY_WORDS.matcher(token);
                        if (!match.find() || !SEARCH.matcher(match.group()).matches()) {
                            throw new IllegalArgumentException();
                        }
                        parsedCommands[i][0] = match.group().toUpperCase();

                        if (!match.find()) {
                            throw new IllegalArgumentException();
                        }
                        parsedCommands[i][1] = match.group();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getCause() + e.getMessage());
        }

        return true;
    }

    public String[][] getArgs() {
        return parsedCommands;
    }
}
