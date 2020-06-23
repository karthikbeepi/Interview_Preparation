using Microsoft.VisualStudio.TestTools.UnitTesting;
using HackerrankInterviewPrep;

namespace HackerrankInterviewTest
{
    [TestClass]
    public class CountValleyTest
    {
       [TestMethod]
       public void Test1()
       {
            var ob = new CountValley();
            Assert.AreEqual(1, ob.countingValleys(8, "UDDDUDUU"));
       }

       [TestMethod]
       public void Test2()
       {
           var ob = new CountValley();
           Assert.AreEqual(3, ob.countingValleys(23, "UDDDUDUUUDDDUDUUUUDDDUU"));
       }
    }
}
