package greedyAlgo.activitySelection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/*
1. Sort the activities according to their finish time
2. Select the first activity from the sorted array and print it
3. Do following for remaining activities in the sorted array
    1. If the start time of this activity is greater than or equal to the finish time of previously selected activity then select this activity and print it

 */
public class ActivitiySelection {
	
	static void activitySelection(ArrayList<Activity> activityList) {
	
		//Implement Comparator interface and specify which variable('FinishTime') of user defined class should the 'compare' method work on.
		//This needs to be done because this will be required in Sort method  
		Comparator<Activity> finishTimeComparator = new Comparator<Activity>() {
			@Override
			public int compare(Activity o1, Activity o2) {
				return o1.getFinishTime() - o2.getFinishTime();
			}
		};
		
		//Sort all the objects stored in the Arraylist by 'FinishTime' variable
		Collections.sort(activityList, finishTimeComparator);
		Activity previousActivity = activityList.get(0);
		
		
		//Print first job
		System.out.println("\n\nRecommended Schedule:\n"+activityList.get(0));
		
		
		//For each job
		for (int i = 1; i < activityList.size() ; i++) {
			Activity activity = activityList.get(i);
			//if job's start time is greater than equal previous job's finish time then print job
			if (activity.getStartTime() >= previousActivity.getFinishTime()) {
				System.out.println(activity);
				previousActivity = activity;
			}
		}
	}
}