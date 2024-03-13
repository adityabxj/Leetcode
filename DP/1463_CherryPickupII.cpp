#include <vector>
#include <algorithm>

using namespace std;

// 1st Approach top-down dynamic programming approach with memoization
class Solution
{
public:
    int cherryPickup(vector<vector<int>> &grid)
    {
        const int m = grid.size();
        const int n = grid[0].size();
        vector<vector<vector<int>>> dp(m + 1,
                                       vector<vector<int>>(n, vector<int>(n)));

        for (int x = m - 1; x >= 0; --x)
            for (int y1 = 0; y1 < n; ++y1)
                for (int y2 = 0; y2 < n; ++y2)
                {
                    const int currRow = grid[x][y1] + (y1 != y2) * grid[x][y2];
                    for (int d1 = max(0, y1 - 1); d1 < min(n, y1 + 2); ++d1)
                        for (int d2 = max(0, y2 - 1); d2 < min(n, y2 + 2); ++d2)
                            dp[x][y1][y2] = max(dp[x][y1][y2], currRow + dp[x + 1][d1][d2]);
                }

        return dp[0][0][n - 1];
    }
};

// 2nd approach Dynamic programming using memoization

class Solution
{
public:
    int cherryPickup(vector<vector<int>> &grid)
    {
        const int m = grid.size();
        const int n = grid[0].size();
        vector<vector<vector<int>>> mem(m,
                                        vector<vector<int>>(n, vector<int>(n, -1)));
        return cherryPick(grid, 0, 0, n - 1, mem);
    }

private:
    int cherryPick(const vector<vector<int>> &grid, int x, int y1, int y2,
                   vector<vector<vector<int>>> &mem)
    {
        if (x == grid.size())
            return 0;
        if (y1 < 0 || y1 == grid[0].size() || y2 < 0 || y2 == grid[0].size())
            return 0;
        if (mem[x][y1][y2] != -1)
            return mem[x][y1][y2];

        const int currRow = grid[x][y1] + (y1 == y2 ? 0 : 1) * grid[x][y2];

        for (int d1 = -1; d1 <= 1; ++d1)
            for (int d2 = -1; d2 <= 1; ++d2)
                mem[x][y1][y2] =
                    max(mem[x][y1][y2],
                        currRow + cherryPick(grid, x + 1, y1 + d1, y2 + d2, mem));

        return mem[x][y1][y2];
    }
};