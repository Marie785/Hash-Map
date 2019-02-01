//
//Marie-Claire Salha
//mjs170530
//
package HashTable;

public class Main 
{
    public static void main(String[] args) 
    {
        Hash H = new Hash();
        
        //rehashing once
        for(int i = 100; i < 105; i++)
        {
            H.insert(i);
        }
        
        //rehashing twice
        for(int i = 246; i < 257; i++)
        {
            H.insert(i);
        }
        H.printArray();
    }
    
}
