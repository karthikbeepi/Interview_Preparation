using System;
using System.Collections.Generic;
using System.Text;

namespace HackerrankInterviewPrep
{
    public class CountValley
    {
        public int countingValleys(int n, string s)
        {
            int valleyCount = 0;
            var valleyLevel = new int[s.Length+1];
            int i = 0;
            valleyLevel[i] = 0;
            i++;
            foreach (char c in s.ToCharArray())
            {
                valleyLevel[i] = (c == 'U') ? valleyLevel[i - 1] + 1 : valleyLevel[i - 1] - 1;
                i++;
            }
            for(int j=1; j<s.Length; j++)
            {
                if (valleyLevel[j] == -1 && valleyLevel[j + 1] == 0)
                    valleyCount++;
            }
            return valleyCount;
        }
    }
}
