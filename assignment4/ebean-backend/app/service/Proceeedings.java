package service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import play.libs.Json;

import java.util.List;

public class Proceeedings {
   static String preceedingsStr = "[{\n" +
            "\t\"title\": \"IEEE International Conference on Web Services, ICWS 2009, Los Angeles, CA, USA, 6-10 July 2009\",\n" +
            "\t\"address\":\"Los Angeles, CA, USA\",\n" +
            "\t\"booktitle\": \"ICWS\",\n" +
            "\t\"publisher\": \"IEEE Computer Society\",\n" +
            "\t\"year\": \"2009\",\n" +
            "\t\"isbn\": \"978-0-7695-3709-2\"\n" +
            "},  {\n" +
            "\t\"title\": \"ProceedingsVo of the International Conference on Web Services, ICWS \\u002703, June 23 - 26, 2003, Las Vegas, Nevada, USA\",\n" +
            "\t\"address\":\"Las Vegas, Nevada, USA\",\n" +
            "\t\"booktitle\": \"IWCS\",\n" +
            "\t\"publisher\": \"CSREA Press\",\n" +
            "\t\"year\": \"2003\",\n" +
            "\t\"isbn\": \"1-892512-49-1\"\n" +
            "},  {\n" +
            "\t\"title\": \"2012 IEEE 19th International Conference on Web Services, Honolulu, HI, USA, June 24-29, 2012\",\n" +
            "\t\"address\":\"Honolulu, HI, USA\",\n" +
            "\t\"booktitle\": \"ICWS\",\n" +
            "\t\"publisher\": \"IEEE Computer Society\",\n" +
            "\t\"year\": \"2012\",\n" +
            "\t\"isbn\": \"978-1-4673-2131-0\"\n" +
            "},  {\n" +
            "\t\"title\": \"IEEE International Conference on Web Services, ICWS 2011, Washington, DC, USA, July 4-9, 2011\",\n" +
            "\t\"address\":\"Washington, DC, USA\",\n" +
            "\t\"booktitle\": \"ICWS\",\n" +
            "\t\"publisher\": \"IEEE Computer Society\",\n" +
            "\t\"year\": \"2011\",\n" +
            "\t\"isbn\": \"978-1-4577-0842-8\"\n" +
            "},  {\n" +
            "\t\"title\": \"2008 IEEE International Conference on Web Services (ICWS 2008), September 23-26, 2008, Beijing, China\",\n" +
            "\t\"address\":\" Beijing, China\",\n" +
            "\t\"booktitle\": \"ICWS\",\n" +
            "\t\"publisher\": \"IEEE Computer Society\",\n" +
            "\t\"year\": \"2008\",\n" +
            "\t\"isbn\": \"978-0-7695-3310-0\"\n" +
            "}, {\n" +
            "\t\"title\": \"2005 IEEE International Conference on Web Services (ICWS 2005), 11-15 July 2005, Orlando, FL, USA\",\n" +
            "\t\"address\":\"Orlando, FL, USA\",\n" +
            "\t\"booktitle\": \"ICWS\",\n" +
            "\t\"publisher\": \"IEEE Computer Society\",\n" +
            "\t\"year\": \"2005\",\n" +
            "\t\"isbn\": \"0-7695-2409-5\"\n" +
            "},  {\n" +
            "\t\"title\": \"Third European Conference on Web Services (ECOWS 2005), 14-16 November 2005, Växjö, Sweden\",\n" +
            "\t\"address\":\"Växjö, Sweden\",\n" +
            "\t\"booktitle\": \"ECOWS\",\n" +
            "\t\"publisher\": \"IEEE Computer Society\",\n" +
            "\t\"year\": \"2005\",\n" +
            "\t\"isbn\": \"0-7695-2484-2\"\n" +
            "},  {\n" +
            "\t\"title\": \"2018 IEEE International Conference on Web Services, ICWS 2018, San Francisco, CA, USA, July 2-7, 2018\",\n" +
            "\t\"address\":\"San Francisco, CA, USA\",\n" +
            "\t\"booktitle\": \"ICWS\",\n" +
            "\t\"publisher\": \"IEEE\",\n" +
            "\t\"year\": \"2018\",\n" +
            "\t\"isbn\": \"978-1-5386-7247-1\"\n" +
            "},{\n" +
            "\t\"title\": \"IEEE International Conference on Web Services, ICWS 2016, San Francisco, CA, USA, June 27 - July 2, 2016\",\n" +
            "\t\"address\":\"San Francisco, CA, USA\",\n" +
            "\t\"booktitle\": \"ICWS\",\n" +
            "\t\"publisher\": \"IEEE Computer Society\",\n" +
            "\t\"year\": \"2016\",\n" +
            "\t\"isbn\": \"978-1-5090-2675-3\"\n" +
            "}, {\n" +
            "\t\"title\": \"2006 IEEE International Conference on Web Services (ICWS 2006), 18-22 September 2006, Chicago, Illinois, USA\",\n" +
            "\t\"address\":\"Chicago, Illinois, USA\",\n" +
            "\t\"booktitle\": \"ICWS\",\n" +
            "\t\"publisher\": \"IEEE Computer Society\",\n" +
            "\t\"year\": \"2006\",\n" +
            "\t\"isbn\": \"0-7695-2669-1\"\n" +
            "}, {\n" +
            "\t\"title\": \"2007 IEEE International Conference on Web Services (ICWS 2007), July 9-13, 2007, Salt Lake City, Utah, USA\",\n" +
            "\t\"address\":\"Salt Lake City, Utah, USA\",\n" +
            "\t\"booktitle\": \"ICWS\",\n" +
            "\t\"publisher\": \"IEEE Computer Society\",\n" +
            "\t\"year\": \"2007\",\n" +
            "\t\"isbn\": \"0-7695-2924-0\"\n" +
            "},  {\n" +
            "\t\"title\": \"2013 IEEE 20th International Conference on Web Services, Santa Clara, CA, USA, June 28 - July 3, 2013\",\n" +
            "\t\"address\":\"Santa Clara, CA, USA\",\n" +
            "\t\"booktitle\": \"ICWS\",\n" +
            "\t\"publisher\": \"IEEE Computer Society\",\n" +
            "\t\"year\": \"2013\",\n" +
            "\t\"isbn\": \"978-0-7695-5025-1\"\n" +
            "},  {\n" +
            "\t\"title\": \"Web Services - ICWS-Europe 2003, International Conference ICWS-Europe 2003, Erfurt, Germany, September 23-24, 2003, ProceedingsVo\",\n" +
            "\t\"address\":\"Erfurt, Germany\",\n" +
            "\t\"booktitle\": \"ICWS-Europe\",\n" +
            "\t\"publisher\": \"Springer\",\n" +
            "\t\"year\": \"2003\",\n" +
            "\t\"isbn\": \"3-540-20125-4\"\n" +
            "},  {\n" +
            "\t\"title\": \"2017 IEEE International Conference on Web Services, ICWS 2017, Honolulu, HI, USA, June 25-30, 2017\",\n" +
            "\t\"address\":\"Honolulu, HI, USA\",\n" +
            "\t\"booktitle\": \"ICWS Computer Society\",\n" +
            "\t\"publisher\": \"IEEE\",\n" +
            "\t\"year\": \"2017\",\n" +
            "\t\"isbn\": \"978-1-5386-0752-7\"\n" +
            "}, {\n" +
            "\t\"title\": \"2014 IEEE International Conference on Web Services, ICWS, 2014, Anchorage, AK, USA, June 27 - July 2, 2014\",\n" +
            "\t\"address\":\"Anchorage, AK, USA\",\n" +
            "\t\"booktitle\": \"ICWS\",\n" +
            "\t\"publisher\": \"IEEE Computer Society\",\n" +
            "\t\"year\": \"2014\",\n" +
            "\t\"isbn\": \"978-1-4799-5054-6\"\n" +
            "}, {\n" +
            "\t\"title\": \"2015 IEEE International Conference on Web Services, ICWS 2015, New York, NY, USA, June 27 - July 2, 2015\",\n" +
            "\t\"address\":\"New York, NY, USA\",\n" +
            "\t\"booktitle\": \"ICWS\",\n" +
            "\t\"publisher\": \"IEEE Computer Society\",\n" +
            "\t\"year\": \"2015\",\n" +
            "\t\"isbn\": \"978-1-4673-7272-5\"\n" +
            "}, {\n" +
            "\t\"title\": \"IEEE International Conference on Web Services, ICWS 2010, Miami, Florida, USA, July 5-10, 2010\",\n" +
            "\t\"address\":\"Miami, Florida, USA\",\n" +
            "\t\"booktitle\": \"ICWS\",\n" +
            "\t\"publisher\": \"IEEE Computer Society\",\n" +
            "\t\"year\": \"2010\",\n" +
            "\t\"isbn\": \"978-0-7695-4128-0\"\n" +
            "}, {\n" +
            "\t\"title\": \"ProceedingsVo of the ICWS 2005 Second International Workshop on Semantic and Dynamic Web Processes, SDWP@ICWS 2005, Orlando, Florida, USA, July 11, 2005.\",\n" +
            "\t\"address\":\"Orlando, Florida, USA\",\n" +
            "\t\"booktitle\": \"SDWP@ICWS\",\n" +
            "\t\"publisher\": \"CEUR-WS.org\",\n" +
            "\t\"year\": \"2005\"\n" +
            "},  {\n" +
            "\t\"title\": \"ProceedingsVo of the IEEE International Conference on Web Services (ICWS\\u002704), June 6-9, 2004, San Diego, California, USA\",\n" +
            "\t\"address\":\"San Diego, California, USA\",\n" +
            "\t\"booktitle\": \"ICWS\",\n" +
            "\t\"publisher\": \"IEEE Computer Society\",\n" +
            "\t\"year\": \"2004\",\n" +
            "\t\"isbn\": \"0-7695-2167-3\"\n" +
            "},  {\n" +
            "\t\"title\": \"Thirteenth International Conference on Quality Control by Artificial Vision, QCAV 2017, Tokyo, Japan, May 14, 2017\",\n" +
            "\t\"address\":\"Tokyo, Japan\",\n" +
            "\t\"booktitle\": \"QCAV\",\n" +
            "\t\"publisher\": \"SPIE\",\n" +
            "\t\"year\": \"2017\",\n" +
            "\t\"isbn\": \"9781510611214\"\n" +
            "}, {\n" +
            "\t\"title\": \"Engineering Dederated Information Systems, ProceedingsVo of the 2nd Workshop EFIS\\u002799, Kühlungsborn, Germany, May 5-7, 1999\",\n" +
            "\t\"address\":\"Kühlungsborn, Germany\",\n" +
            "\t\"booktitle\": \"EFIS\",\n" +
            "\t\"publisher\": \"Infix, Sankt Augustin\",\n" +
            "\t\"year\": \"1999\",\n" +
            "\t\"isbn\": \"3-89601-013-1\"\n" +
            "}, {\n" +
            "\t\"title\": \"Engineering Federated Information Systems, ProceedingsVo of the 5th Workshop EFIS 2003, July 17-18 2003, Coventry, UK\",\n" +
            "\t\"address\":\"Coventry, UK\",\n" +
            "\t\"booktitle\": \"EFIS\",\n" +
            "\t\"publisher\": \"aka / IOS Press / infix\",\n" +
            "\t\"year\": \"2003\",\n" +
            "\t\"isbn\": \"3-89838-041-6\"\n" +
            "},  {\n" +
            "\t\"title\": \"2007 IEEE International Conference on Services Computing - Workshops (SCW 2007), 9-13 July 2007, Salt Lake City, Utah, USA\",\n" +
            "\t\"address\":\"Salt Lake City, Utah, USA\",\n" +
            "\t\"booktitle\": \"IEEE SCW\",\n" +
            "\t\"publisher\": \"IEEE Computer Society\",\n" +
            "\t\"year\": \"2007\"\n" +
            "},  {\n" +
            "\t\"title\": \"2009 IEEE International Conference on Services Computing (SCC 2009), 21-25 September 2009, Bangalore, India\",\n" +
            "\t\"address\":\"Bangalore, India\",\n" +
            "\t\"booktitle\": \"IEEE SCC\",\n" +
            "\t\"publisher\": \"IEEE Computer Society\",\n" +
            "\t\"year\": \"2009\",\n" +
            "\t\"isbn\": \"978-0-7695-3811-2\"\n" +
            "},{\n" +
            "\t\"title\": \"2012 IEEE Ninth International Conference on Services Computing, Honolulu, HI, USA, June 24-29, 2012\",\n" +
            "\t\"address\":\"Honolulu, HI, USA\",\n" +
            "\t\"booktitle\": \"IEEE SCC\",\n" +
            "\t\"publisher\": \"IEEE Computer Society\",\n" +
            "\t\"year\": \"2012\",\n" +
            "\t\"isbn\": \"978-1-4673-3049-7\"\n" +
            "},{\n" +
            "\t\"title\": \"IEEE International Conference on Services Computing, SCC 2011, Washington, DC, USA, 4-9 July, 2011\",\n" +
            "\t\"address\":\"Washington, DC, USA\",\n" +
            "\t\"booktitle\": \"IEEE SCC\",\n" +
            "\t\"publisher\": \"IEEE Computer Society\",\n" +
            "\t\"year\": \"2011\",\n" +
            "\t\"isbn\": \"978-1-4577-0863-3\"\n" +
            "}, {\n" +
            "\t\"title\": \"2008 IEEE International Conference on Services Computing (SCC 2008), 8-11 July 2008, Honolulu, Hawaii, USA\",\n" +
            "\t\"address\":\"Honolulu, Hawaii, USA\",\n" +
            "\t\"booktitle\": \"IEEE SCC\",\n" +
            "\t\"publisher\": \"IEEE Computer Society\",\n" +
            "\t\"year\": \"2008\",\n" +
            "\t\"isbn\": \"978-0-7695-3283-7\"\n" +
            "}, {\n" +
            "\t\"title\": \"2005 IEEE International Conference on Services Computing (SCC 2005), 11-15 July 2005, Orlando, FL, USA\",\n" +
            "\t\"address\":\"Orlando, FL, USA\",\n" +
            "\t\"booktitle\": \"IEEE SCC\",\n" +
            "\t\"publisher\": \"IEEE Computer Society\",\n" +
            "\t\"year\": \"2005\",\n" +
            "\t\"isbn\": \"0-7695-2408-7\"\n" +
            "}, {\n" +
            "\t\"title\": \"2018 IEEE International Conference on Services Computing, SCC 2018, San Francisco, CA, USA, July 2-7, 2018\",\n" +
            "\t\"address\":\"San Francisco, CA, USA\",\n" +
            "\t\"booktitle\": \"SCC\",\n" +
            "\t\"publisher\": \"IEEE\",\n" +
            "\t\"year\": \"2018\",\n" +
            "\t\"isbn\": \"978-1-5386-7250-1\"\n" +
            "}, {\n" +
            "\t\"title\": \"IEEE International Conference on Services Computing, SCC 2016, San Francisco, CA, USA, June 27 - July 2, 2016\",\n" +
            "\t\"address\":\"San Francisco, CA, USA\",\n" +
            "\t\"booktitle\": \"SCC\",\n" +
            "\t\"publisher\": \"IEEE Computer Society\",\n" +
            "\t\"year\": \"2016\",\n" +
            "\t\"isbn\": \"978-1-5090-2628-9\"\n" +
            "}, {\n" +
            "\t\"title\": \"2006 IEEE International Conference on Services Computing (SCC 2006), 18-22 September 2006, Chicago, Illinois, USA\",\n" +
            "\t\"address\":\"Chicago, Illinois, USA\",\n" +
            "\t\"booktitle\": \"IEEE SCC\",\n" +
            "\t\"publisher\": \"IEEE Computer Society\",\n" +
            "\t\"year\": \"2006\",\n" +
            "\t\"isbn\": \"0-7695-2670-5\"\n" +
            "},  {\n" +
            "\t\"title\": \"2007 IEEE International Conference on Services Computing (SCC 2007), 9-13 July 2007, Salt Lake City, Utah, USA\",\n" +
            "\t\"address\":\"Salt Lake City, Utah, USA\",\n" +
            "\t\"booktitle\": \"IEEE SCC\",\n" +
            "\t\"publisher\": \"IEEE Computer Society\",\n" +
            "\t\"year\": \"2007\",\n" +
            "\t\"isbn\": \"0-7695-2925-9\"\n" +
            "}, {\n" +
            "\t\"title\": \"2013 IEEE International Conference on Services Computing, Santa Clara, CA, USA, June 28 - July 3, 2013\",\n" +
            "\t\"address\":\"Santa Clara, CA, USA\",\n" +
            "\t\"booktitle\": \"IEEE SCC\",\n" +
            "\t\"publisher\": \"IEEE Computer Society\",\n" +
            "\t\"year\": \"2013\",\n" +
            "\t\"isbn\": \"978-0-7695-5026-8\"\n" +
            "}, {\n" +
            "\t\"title\": \"2017 IEEE International Conference on Services Computing, SCC 2017, Honolulu, HI, USA, June 25-30, 2017\",\n" +
            "\t\"address\":\"Honolulu, HI, USA\",\n" +
            "\t\"booktitle\": \"SCC\",\n" +
            "\t\"publisher\": \"IEEE Computer Society\",\n" +
            "\t\"year\": \"2017\",\n" +
            "\t\"isbn\": \"978-1-5386-2005-2\"\n" +
            "}, {\n" +
            "\t\"title\": \"IEEE International Conference on Services Computing, SCC 2014, Anchorage, AK, USA, June 27 - July 2, 2014\",\n" +
            "\t\"address\":\"Anchorage, AK, USA\",\n" +
            "\t\"booktitle\": \"IEEE SCC\",\n" +
            "\t\"publisher\": \"IEEE Computer Society\",\n" +
            "\t\"year\": \"2014\",\n" +
            "\t\"isbn\": \"978-1-4799-5065-2\"\n" +
            "}, {\n" +
            "\t\"title\": \"2015 IEEE International Conference on Services Computing, SCC 2015, New York City, NY, USA, June 27 - July 2, 2015\",\n" +
            "\t\"address\":\"New York City, NY, USA\",\n" +
            "\t\"booktitle\": \"SCC\",\n" +
            "\t\"publisher\": \"IEEE Computer Society\",\n" +
            "\t\"year\": \"2015\",\n" +
            "\t\"isbn\": \"978-1-4673-7281-7\"\n" +
            "}, {\n" +
            "\t\"title\": \"2010 IEEE International Conference on Services Computing, SCC 2010, Miami, Florida, USA, July 5-10, 2010\",\n" +
            "\t\"address\":\"Miami, Florida, USA\",\n" +
            "\t\"booktitle\": \"IEEE SCC\",\n" +
            "\t\"publisher\": \"IEEE Computer Society\",\n" +
            "\t\"year\": \"2010\",\n" +
            "\t\"isbn\": \"978-0-7695-4126-6\"\n" +
            "},  {\n" +
            "\t\"title\": \"2004 IEEE International Conference on Services Computing (SCC 2004), 15-18 September 2004, Shanghai, China\",\n" +
            "\t\"address\":\"Shanghai, China\",\n" +
            "\t\"booktitle\": \"IEEE SCC\",\n" +
            "\t\"publisher\": \"IEEE Computer Society\",\n" +
            "\t\"year\": \"2004\",\n" +
            "\t\"isbn\": \"0-7695-2225-4\"\n" +
            "}]";

    public static List<ProceedingsVo> proceedingsVoList = null;

    static {
        proceedingsVoList = new Gson().fromJson(preceedingsStr, new TypeToken<List<ProceedingsVo>>() {}.getType());
    }

    public static void main(String[] args){
        List<ProceedingsVo> aa = proceedingsVoList;
        System.out.println("123");
    }

    public static List<ProceedingsVo> getProceedingsVoList() {
        return new Gson().fromJson(preceedingsStr, new TypeToken<List<ProceedingsVo>>() {}.getType());
    }
}
