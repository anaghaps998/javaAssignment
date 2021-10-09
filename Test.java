import java.util.*;
import java.lang.*;
import org.json.*;

class Test{

  Hashtable dataStore = new Hashtable();


  public void insertUrl(String url){
    if(dataStore.get(url) == null){
      final String uuid = UUID.randomUUID().toString();
      String value = uuid + ", " + 0;
      dataStore.put(url, value);
    }
    else{
      String value = dataStore.get(url).toString();
      String[] values = value.split(", ");
      String uniqueKey = values[0];
      int usageCount = Integer.parseInt(values[1]) + 1;

      dataStore.put(url, uniqueKey + ", " + usageCount);
    }
  }

  public String getUrl(String url){
    String uniqueKey = null;
    if(dataStore.get(url) != null){
      String value = dataStore.get(url).toString();
      String[] values = value.split(", ");
      uniqueKey = values[0];
    }

    return uniqueKey;
  }

  public int getCount(String url){
    if(dataStore.get(url) != null){
      String value = dataStore.get(url).toString();
      String[] values = value.split(", ");
      int usageCount = Integer.parseInt(values[1]);
      return usageCount;
    }
    return 0;
  }

  public void getList(){
    Enumeration<String> _enum = dataStore.keys();

    JSONObject json = new JSONObject();
    while(_enum.hasMoreElements()){
      String key = _enum.nextElement();
      String value = dataStore.get(key).toString();
      String[] values = value.split(", ");

      JSONArray array = new JSONArray();
      for(int index=0;index<values.length;index++){
        array.put(values[index]);
      }
      json.put(key, array);
    }

    System.out.println(json);
  }

  public Test(){
    System.out.println("Program started ...");
    while(true){
      Scanner scanner = new Scanner(System.in);
      String userInput = scanner.nextLine();
      if(userInput.equals("exit")){
        System.exit(1);
      }
      else if(userInput.contains("storeurl")){
        String[] breakdown = userInput.split(" ");
        String url = breakdown[1];
        insertUrl(url);
      }
      else if(userInput.contains("get")){
        String[] breakdown = userInput.split(" ");
        String url = breakdown[1];
        System.out.println(getUrl(url));
      }
      else if(userInput.contains("count")){
        String[] breakdown = userInput.split(" ");
        String url = breakdown[1];
        System.out.println(getCount(url));
      }
      else if(userInput.equals("list")){
        getList();
      }
      else{
        System.out.println("Invalid input");
      }
    }
    // insertUrl("test");
    // insertUrl("test");
    // System.out.println(getCount("test"));
  }

  public static void main(String args[]){
    new Test();
  }
}
