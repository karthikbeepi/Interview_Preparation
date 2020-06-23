using Microsoft.VisualStudio.TestTools.UnitTesting;
using HackerrankInterviewPrep;

namespace HackerrankInterviewTest
{
    [TestClass]
    public class SockMerchantTest
    {
        [TestMethod]
        public void sockMerchantTest1()
        {
            var ob = new SockMerchant();
            Assert.AreEqual(2, ob.sockMerchant(7, new int[] { 1, 2, 1, 2, 1, 3, 2 }));
        }

        [TestMethod]
        public void sockMerchantTest2()
        {
            var ob = new SockMerchant();
            Assert.AreEqual(3, ob.sockMerchant(9, new int[] { 10, 20, 20, 10, 10, 30, 50, 10, 20 }));
        }

        [TestMethod]
        public void sockMerchantTest3()
        {
            var ob = new SockMerchant();
            Assert.AreEqual(39, ob.sockMerchant(90, new int[]
            {
                10, 20, 20, 10, 10, 30, 50, 10, 20,
                10, 20, 20, 10, 10, 30, 50, 10, 20,
                10, 20, 20, 10, 10, 30, 50, 10, 20,
                10, 20, 20, 10, 10, 30, 50, 10, 20,
                10, 20, 20, 10, 10, 30, 50, 10, 20,
                10, 20, 20, 10, 10, 30, 50, 10, 20,
                10, 20, 20, 10, 10, 30, 50, 10, 20,
                10, 20, 20, 10, 10, 30, 50, 10, 20,
                10, 20, 20, 10, 10, 30, 50, 10, 20
            }));
        }
    }
}
