using System;
using System.Collections.Generic;
using System.Text;

namespace HackerrankInterviewPrep
{
    public class InfiniteString
    {
        public long RepeatedString(string s, long n)
        {
            int noOfAInString = 0;
            long noOfAinInfiniteString = n / s.Length;
            long remainder = n % s.Length;
            int countAInStringRem = 0;
            for(int i=0; i<s.Length; i++)
            {
                if (s[i] == 'a' || s[i] == 'A')
                {
                    noOfAInString++;
                    if (i < remainder)
                        countAInStringRem++;
                }
            }

            return (noOfAinInfiniteString*noOfAInString) + countAInStringRem;

        }
    }
}
