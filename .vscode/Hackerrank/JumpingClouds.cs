using System;
using System.Collections.Generic;
using System.Text;

namespace HackerrankInterviewPrep
{
    public class JumpingClouds
    {
        public int JumpingOnClouds(int[] c)
        {
            int noOfJumps = 0;
            int cur = 0;
            while(cur<c.Length-2)
            {
                if (c[cur + 2] == 0)
                    cur += 2;
                else
                    cur += 1;
                noOfJumps++;
            }

            if (cur != c.Length - 1)
                noOfJumps++;

            return noOfJumps;

        }
    }
}
