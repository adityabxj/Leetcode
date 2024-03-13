// class Solution
// {
// public:
//     long long largestPerimeter(vector<int> &nums)
//     {
//         long prefix = 0;
//         for (int num : nums)
//         {
//             prefix += num;
//         }
//         sort(nums.begin(), nums.end());
//         for (int i = nums.size() - 1; i >= 2; --i)
//         {
//             prefix -= nums[i];
//             if (prefix > nums[i])
//                 return prefix + nums[i];
//         }
//         return -1;
//     }
// };