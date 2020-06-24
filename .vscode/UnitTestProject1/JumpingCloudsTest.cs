using Microsoft.VisualStudio.TestTools.UnitTesting;
using HackerrankInterviewPrep;

namespace HackerrankInterviewTest
{
    [TestClass]
    public class JumpingCloudsTest
    {
        [TestMethod]
        public void Test1()
        {
            var ob = new JumpingClouds();
            Assert.AreEqual(4, ob.JumpingOnClouds(new int[] { 0, 0, 1, 0, 0, 1, 0 }));
        }

        [TestMethod]
        public void Test2()
        {
            var ob = new JumpingClouds();
            Assert.AreEqual(3, ob.JumpingOnClouds(new int[] { 0, 0, 0, 0, 1, 0 }));
        }

        [TestMethod]
        public void Test3()
        {
            var ob = new JumpingClouds();
            Assert.AreEqual(3, ob.JumpingOnClouds(new int[] { 0, 1, 0, 0, 0, 1, 0 }));
        }

        [TestMethod]
        public void Test4()
        {
            var ob = new JumpingClouds();
            Assert.AreEqual(3, ob.JumpingOnClouds(new int[] { 0, 0, 0, 1, 0, 0 }));
        }
    }
}
