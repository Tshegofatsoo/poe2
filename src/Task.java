public class Task {
    String input="";
    String taskDescription;
    
    //METHOD TO CHECK IF TASK DESCRIPTION<=50
    public boolean checkTaskDescription() {
       Boolean Verify=false;
       for (int i=0; i<taskDescription.length(); i++){
           if (taskDescription.length() <= 50){
               Verify = true;
           }
       }
    return Verify;
    }
    
    public String createTaskID(String taskName, int taskNumber, String developerLastName) {
        String taskID = taskName.substring(0, 2).toUpperCase() + ":" + taskNumber + ":" +
                developerLastName.substring(developerLastName.length() - 3).toUpperCase();
        return taskID;
    }
     //METHOD TO RETURN TASK DETAILS
    public String printTaskDetails(String taskStatus, String developerFirstName, String developerLastName, int taskNumber,
                                   String taskName, String taskDescription, String taskID, int taskDuration) {
        String details = "Task Status: " + taskStatus + "\nDeveloper: " + developerFirstName + " " + developerLastName +
                "\nTask Number: " + taskNumber + "\nTask Name: " + taskName + "\nTask Description: " +
                taskDescription + "\nTask ID: " + taskID + "\nTask Duration: " + taskDuration + " hours";
        return details;
    }
   
    public int returnTotalHours(int... durations) {
        int total = 0;
        for (int duration : durations) {
            total += duration;
        }
        //METHOD TO RETURN TOTAL HOURS
        return total;
    }
}
