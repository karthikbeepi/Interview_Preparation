using System;
using System.Collections.Generic;
using System.Text;

namespace HackerrankInterviewPrep
{
    public class SockMerchant
    {
        public int sockMerchant(int n, int[] ar)
        {
            var sockCountDictionary = new Dictionary<int, int>();
            int noOfPairs = 0;
            foreach (int i in ar)
            {
                if (sockCountDictionary.ContainsKey(i))
                    sockCountDictionary[i]++;
                else
                    sockCountDictionary.Add(i, 1);
            }
            foreach (int i in sockCountDictionary.Keys)
            {
                noOfPairs += sockCountDictionary[i] / 2;
            }
            return noOfPairs;
        }
    }
}
