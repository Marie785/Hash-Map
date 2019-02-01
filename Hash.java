//
//Marie-Claire Salha
//mjs170530
//
package HashTable;
import java.math.*;
public class Hash 
{
    //makes an array for the hash table
    final double loadFactor = 0.5;
    int [] hashArray = new int[11];
    int size = 11;
    int numTaken = 0;   //this will keep track of if we've gone over the load factor or not
    
    public void insert(int key)
    {
        int loadNum = (int)(size * loadFactor);     //this will determine the load factor
        int element = 0;    //this keeps track of the element we're trying to insert into
        int i = 0;  //this will increment to go through all of the elements of the array
        boolean empty = true;
        
        //while it has not found an empty spot yet, keep looping through the
        //array
        while(empty != false)
        {
            element = ((key + i*i) % size); //determines where we will attempt to insert the key into
            
            //if that element is empty, then we'll insert it into the array
            if(hashArray[element] == 0)
            {
                empty = false;  //sets empty equal to false because that element will no longer be empty
                numTaken++;     //increase the number of taken spots in the array by one
                hashArray[element] = key;   //enter in the key into the array
            }
            
            if(numTaken >= loadNum) //if we haver eached the load factor, then we will rehash our array
            {
                reHash();
                break;
            }
            
            i++;
        }
    }
    
    public void reHash()
    {
        int prev = size;
        BigInteger prime = new BigInteger(String.valueOf(size * 2));
        prime = prime.nextProbablePrime();
        size = prime.intValue();
        
        numTaken = 0;
        int element = 0;
        int j = 0;
        int [] tempArray = new int [size];
        boolean empty = true;
        
        //enters in the original array's keys to the new array to be copied over
        for(int i = 0; i < prev; i++)
        {
            while(empty != false)
            {
                element = ((hashArray[i] + j*j) % size); //determines where we will attempt to insert the key into
            
                //if that element is empty, then we'll insert it into the array
                if(tempArray[element] == 0)
                {
                    empty = false;  //sets empty equal to false because that element will no longer be empty
                    numTaken++;     //increase the number of taken spots in the array by one
                    tempArray[element] = hashArray[i];   //enter in the key into the array
                }
                
                j++;
            }
            empty = true;
        }
        
        hashArray = tempArray;  //sets the original array to the new size
    }
    
    public void printArray()
    {
        System.out.println("Array:");
        
        for(int i = 0; i < size; i ++)
        {
            if(hashArray[i] != 0)
                System.out.println(hashArray[i]);
        }
        
        System.out.println();
    }
}
