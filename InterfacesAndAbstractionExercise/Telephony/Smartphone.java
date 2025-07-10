package InterfacesAndAbstractionExercise.Telephony;

import java.util.List;

public class Smartphone implements Callable,Browsable{
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {

        StringBuilder builder = new StringBuilder();

        urls.stream().forEach(url -> {
            if (isValidUrl(url)){
                builder.append("Browsing: ").append(url).append("!").append(System.lineSeparator());
            }else {
                builder.append("Invalid URL!").append(System.lineSeparator());
            }

        });


        return builder.toString();
    }
    private boolean isValidUrl(String url){
        for (int i = 0; i < url.length(); i++) {
            if (Character.isDigit(url.charAt(i))){
                return false;
            }
        }
        return true;
    }




    @Override
    public String call() {
        StringBuilder builder = new StringBuilder();

        numbers.stream().forEach(number -> {
            if (isValidNumber(number)){
                builder.append("Calling... ").append(number).append(System.lineSeparator());
            }else {
                builder.append("Invalid number!").append(System.lineSeparator());
            }

        });

        return builder.toString();
    }

    private boolean isValidNumber(String number){
        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))){
                return false;
            }

        }
        return true;
    }
}
