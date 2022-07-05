package RCBTeam.RCBTeam;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.JsonUtils;
import io.restassured.path.json.JsonPath;


public class RCBTeamTest 
{
    
    @Test
    public void validateForeignPlayers()
    {
    	 String teamDetails=JsonUtils.convertJsonFileToString("teamDetails");
    	 JsonPath js=new JsonPath(teamDetails);
    	 int totalNumberOfPlayers=js.get("player.size()");
    	 int actualForeignPlayers=0;
    	 int expectedForeignPlayers=4;
    	 for(int i=0;i<totalNumberOfPlayers;i++) {
    		 System.out.println(js.getString("player["+i+"].country"));
    		 if(!js.getString("player["+i+"].country").equalsIgnoreCase("india"));
    		 {
    			 actualForeignPlayers++;
    		 }
    	 }
    	 Assert.assertEquals(actualForeignPlayers, expectedForeignPlayers);
    }
    
    @Test
    public void validateWicketKeeper() {
    	String teamDetails=JsonUtils.convertJsonFileToString("teamDetails");
   	 	JsonPath js=new JsonPath(teamDetails);
    	 int totalNumberOfPlayers=js.get("player.size()");
    	 int actualWicketKeepers=0;
    	 int expectedWicketKeepers=1;
    	 for(int i=0;i<totalNumberOfPlayers;i++) {
    		 if(js.getString("player["+i+"].role").equalsIgnoreCase("Wicket-keeper"));
    		 {
    			 actualWicketKeepers++;
    			 if(actualWicketKeepers==1) {
    				 break;
    			 }
    		 }
    	 }
    	 if(actualWicketKeepers >= expectedWicketKeepers) {
    		 Assert.assertTrue(true);
    	 }
    }
}
