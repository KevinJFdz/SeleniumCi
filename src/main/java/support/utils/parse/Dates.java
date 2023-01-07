package support.utils.parse;

public class Dates {

    public Integer parseStringMonthToInteger(String monthToParse) {
        monthToParse = monthToParse.toLowerCase();
        if (monthToParse.contains("jan") || monthToParse.contains("ene")) {
            return 1;
        } else if (monthToParse.contains("feb")) {
            return 2;
        } else if (monthToParse.contains("mar")) {
            return 3;
        } else if (monthToParse.contains("apr") || monthToParse.contains("abr")) {
            return 4;
        } else if (monthToParse.contains("may")) {
            return 5;
        } else if (monthToParse.contains("jun")) {
            return 6;
        } else if (monthToParse.contains("jul")) {
            return 7;
        } else if (monthToParse.contains("aug") || monthToParse.contains("ago")) {
            return 8;
        } else if (monthToParse.contains("sep")) {
            return 9;
        } else if (monthToParse.contains("oct")) {
            return 10;
        } else if (monthToParse.contains("nov")) {
            return 11;
        } else if (monthToParse.contains("dec") || monthToParse.contains("dic")) {
            return 12;
        }
        return null;
    }
    public String parseToDateFormat(String date){
        String[] dateFormat = date.split(" ", 3);
        String month = String.valueOf(parseStringMonthToInteger(dateFormat[0]));
        if(month.length()==1){month="0"+month;}
        String day = dateFormat[1].substring(0,dateFormat[1].length()-1);
        if (day.length()==1){day="0"+day;}
        String finalDate = day+"/"+month+"/"+dateFormat[2];
        return finalDate;
    }
}
