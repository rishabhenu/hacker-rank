package freshers.test.again.array;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class RemoveSpacesFromString {
	
	public static void mains(String... strings) {
		String s = "Hello,Rishabh,\"Vill,Badla\",Hamirpur";
		for (String temp : s.split(",(?=(?:[^\"]*\"[^\"]+\")*[^\"]+$)")) {
			System.out.println(temp);
		}
	}

	public static void main(String args[]) {
		String s = "Rishabh i   s a     goo     boy.";
		s = s.replaceAll("[\\s]([\\s]+)[\\s]", " ");
		System.out.println(s);
	}

	String s = 
		"select "  
	    + "v.year, v.make_name, v.model_name, v.series_name, v.vin, v.vehicle_id, "
	    + "pr.*, "
	    + "cgc.*, "
	    + "(select context_status_id from vehicle_contexts where vehicle_id = v.vehicle_id and task_id = 414 and CONTEXT_STATUS_ID in (1,2) and rownum = 1) as pdiStatus, "
	    + "(select CAR_GROUP_CONFIGS_PARAMS_VALUE from CAR_GROUP_CONFIGS_PARAMS where CAR_GROUP_CONFIG_ID = v.CAR_GROUP_CONFIG_ID and ACTIVE = 1 " 
	    + "and CAR_GROUP_CONFIGS_PARAMS_NAME='DO_NOT_SHOW_COS') as doNotShowCos "
	    + "from CHASE_MEPP_TARGET_DEALERS cmtd, " 
	    + "CHASE_MEPP_TARGET_MODELS cmtm, "
	    + "CHASE_MEPP_VEHICLE_ACTIVITIES cmva, "
	    + "VEHICLES v, PURCHASE_RECEIPTS pr, CAR_GROUP_CONFIGS cgc "
	    + "WHERE cmtd.CHASE_MEPP_TARGET_DEALER_ID = cmtm.CHASE_MEPP_TARGET_DEALER_ID "
	    + "AND cmtm.CHASE_MEPP_TARGET_DEALER_ID = cmva.CHASE_MEPP_TARGET_MODEL_ID "
	    + "AND cmva.VEHICLE_ID = v.VEHICLE_ID "
	    + "AND cmva.IS_SOLD = 1 "
	    + "AND v.VEHICLE_ID = pr.VEHICLE_ID "
	    + "AND v.CAR_GROUP_CONFIG_ID = cgc.CAR_GROUP_CONFIG_ID "
	    + "AND cmtd.CHASE_MEPP_TARGET_DEALER_ID in (select chase_mepp_target_dealer_id from chase_mepp_target_dealers)";

}
