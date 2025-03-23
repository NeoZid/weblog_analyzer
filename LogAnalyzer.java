/**
 * Read web server data and analyse hourly access patterns.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version    2016.02.29
 */
public class LogAnalyzer
{
    /*
     * 1) The busiest times of the day is at 18H, 10H and 14H
     * 
     * 5) int[] counts; and boolean[] machines;
     * 7) 20 elements, objects
     * 8) double[] prices = new double[];
     * 11) public void printGreater(double marks, double mean) {
            for(index = 0; index <= marks.length; index++) {
                if(marks[index] > mean) {
            System.out.println(marks[index]);
            
        12) 

     */
    
    // #2 and #3
    private String[] people;
    private boolean[] vacant;
    
    // #6
    private String[] ticketMachine;
    

    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;
    
    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer()
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        
        // #2 and #3
        reader = new LogfileReader();
        people = new String[2]; // paramater 2 is just sample so it compiles
        
        // #6
        double[] readings;
        readings = new double[60];
        
        String[] urls;
        urls = new String[90];
        
        ticketMachine = new String[5];
        
        // #
    }

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }

    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        for(int hour = 0; hour < hourCounts.length; hour++) {
            System.out.println(hour + ": " + hourCounts[hour]);
        }
    }
    
    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }
    
    // # 13
    public int numberOfAccesses(){
        int total = 0;
        
        for (int count : hourCounts) {
            total += count;
        }
        
        return total;
    }
}