import org.json.JSONException;
import org.json.JSONObject;


import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Chatbot {

    public static String getTime(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String time=timeFormat.format(calendar.getTime());
        return time;
    }

    public static String getDayInfo(){
        Calendar calendar = Calendar.getInstance();
        int day_of_week = calendar.get(Calendar.DAY_OF_WEEK);
        String day="";
        switch(day_of_week){
            case 1:
                day="Today is Sunday";
                break;
            case 2:
                day="Today is Monday";
                break;
            case 3:
                day="Today is Tuesday.";
                break;
            case 4:
                day="Today is Wednesday.";
                break;
            case 5:
                day="Today is Thursday.";
                break;
            case 6:
                day="Today is Friday.";
                break;
            case 7:
                day="Today is Saturday.";
                break;
            default:

                break;
        }
        return day;
    }

    public static String getWeatherInfo() {


        try {
            String readJson = URLReader.read();

            JSONObject j = new JSONObject(readJson);

            String weather =j.getJSONArray("weather").getJSONObject(0).getString("main");
            String res=weather;
            weather= String.valueOf(j.getJSONObject("main").getDouble("temp"))+"";
            res+=","+"Temperature is "+weather+ " K.";
            weather= String.valueOf(j.getJSONObject("main").getDouble("pressure"))+"";
            res+="\n Pressure is "+ weather+" hPa.";

            return res;

        } catch(JSONException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
