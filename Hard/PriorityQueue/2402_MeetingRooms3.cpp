#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

class Solution
{
public:
    int mostBooked(int n, vector<vector<int>> &meetings)
    {
        sort(meetings.begin(), meetings.end()); // Sort meetings based on start time

        priority_queue<pair<long long, int>, vector<pair<long long, int>>, greater<pair<long long, int>>> minHeap; // Min heap to store meetings' end times and room numbers

        vector<int> roomCount(n, 0); // Array to keep track of the number of meetings in each room

        int result = 0; // Variable to store the room with the most meetings

        // Initialize minHeap with all rooms available at time 0
        for (int i = 0; i < n; ++i)
            minHeap.push({0, i});

        // Iterate through each meeting
        for (const auto &meeting : meetings)
        {
            int start = meeting[0];
            int end = meeting[1];
            int value = meeting[2];

            // Update minHeap to reflect the current time
            while (!minHeap.empty() && minHeap.top().first < start)
            {
                auto current = minHeap.top();
                minHeap.pop();
                minHeap.push({start, current.second});
            }

            // Attend the meeting with the earliest end time
            auto current = minHeap.top();
            minHeap.pop();
            int curRoom = current.second;
            long long meetingEndTime = current.first + (end - start);
            roomCount[curRoom]++;

            // Update the result based on the room with the most meetings
            if (roomCount[curRoom] > roomCount[result])
                result = curRoom;
            else if (roomCount[curRoom] == roomCount[result])
                result = min(result, curRoom);

            // Add the next available time slot for the current room to minHeap
            minHeap.push({meetingEndTime, curRoom});
        }

        // Return the room with the most meetings
        return result;
    }
};
