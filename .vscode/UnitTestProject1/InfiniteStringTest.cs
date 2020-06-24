using Microsoft.VisualStudio.TestTools.UnitTesting;
using HackerrankInterviewPrep;

namespace HackerrankInterviewTest
{
    [TestClass]
    public class InfiniteStringTest
    {
        [TestMethod]
        public void Test1()
        {
            InfiniteString ob = new InfiniteString();
            Assert.AreEqual(7, ob.RepeatedString("aba", 10));
        }

        [TestMethod]
        public void Test2()
        {
            InfiniteString ob = new InfiniteString();
            Assert.AreEqual(1000000000000, ob.RepeatedString("a", 1000000000000));
        }

        [TestMethod]
        public void Test3()
        {
            InfiniteString ob = new InfiniteString();
            Assert.AreEqual(4, ob.RepeatedString("abcac", 10));
        }
    }
}
