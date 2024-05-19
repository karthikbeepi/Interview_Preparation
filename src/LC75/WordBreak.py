class Solution:
    def break_the_word(self, s: str) -> bool:
        print(f"{s}  {self.dp}")
        if s in self.dp:
            return self.dp[s]
        
        for word in self.wordDict:
            if s.startswith(word):
                if self.break_the_word(s[len(word):]):
                    self.dp[s] = True

        if s not in self.dp:
            self.dp[s] = False

        return self.dp[s]



    def wordBreak(self, s: str, wordDict: list[str]) -> bool:
        """
        Basic idea, use a pointer and check 
        s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]

        Try backtracking approach, were you choose a word and see if it fits. 
        If it does, then use it and do a replace. 

        break_the_word("catsandog", ["cats","dog","sand","and","cat"])
        -> break_the_word("andog", ["dog","sand","and","cat"])
        -> break_the_word("an", ["sand","and","cat"])

        Check if any of the word is contained within s, if yes. Try with it. 
        (Maybe make it DP later on?)
        """

        self.wordDict = wordDict

        self.dp = {"": True}

        return self.break_the_word(s)

obj = Solution()

test_cases = [
    ("catsandog", ["cats","dog","sand","and","cat"]), 
    ("leetcode", ["leet", "code"]), 
    ("applepenapple", ["apple", "pen"]),
    ("applepenapples", ["apple", "pen", "apples"]),
    ("bcda", ["cd", "ba"]),
]


for tc in test_cases:
    print(f"For {tc}: {obj.wordBreak(tc[0], tc[1])}\n\n")
    