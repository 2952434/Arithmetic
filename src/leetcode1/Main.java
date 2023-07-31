package leetcode1;

import java.util.*;

public class Main {

    /**
     * 不同的平均值数目
     *
     * @param nums
     * @return
     */
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        Set<Integer> set = new HashSet<>();
        while (start < end) {
            set.add(nums[start] + nums[end]);
            start++;
            end--;
        }
        return set.size();
    }

    public String reverseLeftWords(String s, int n) {
        String substring = s.substring(0, n);
        String substring1 = s.substring(n - 1);
        return substring1 + substring;
    }

    public int[] applyOperations(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                index++;
            }
        }
        return nums;
    }


    public int equalPairs(int[][] grid) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < grid.length; i++) {
            List<Integer> orDefault = map.getOrDefault(grid[i][0], new ArrayList<>());
            orDefault.add(i);
            map.put(grid[i][0], orDefault);
        }

        int[] ints = grid[0];
        int ren = 0;
        for (int i = 0; i < ints.length; i++) {
            int h = ints[i];
            if (map.containsKey(h)) {
                List<Integer> list = map.get(h);
                c:
                for (int j = 0; j < list.size(); j++) {
                    Integer l = list.get(j);
                    for (int k = 0; k < grid.length; k++) {
                        if (grid[l][k] != grid[k][i]) {
                            continue c;
                        }
                    }
                    ren++;
                }
            }
        }
        return ren;
    }

    /**
     * 老鼠和奶酪
     *
     * @param reward1
     * @param reward2
     * @param k
     * @return
     */
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        PriorityQueue<Reward> queue = new PriorityQueue<>((o1, o2) -> o2.value - o1.value);

        for (int i = 0; i < reward1.length; i++) {
            int value = reward1[i] - reward2[i];
            Reward reward = new Reward(value, i);
            queue.add(reward);
        }
        Set<Integer> set1 = new HashSet<>();
        int res = 0;
        for (int i = 0; i < k; i++) {
            Reward reward = queue.poll();
            res += reward1[reward.index];
            set1.add(reward.index);
        }
        for (int i = 0; i < reward2.length; i++) {
            if (!set1.contains(i)) {
                res += reward2[i];
            }
        }
        return res;

    }

    class Reward {
        int value;
        int index;

        public Reward() {
        }

        public Reward(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;

        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;

    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }


    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] arr = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            arr[i] = f(words[i]);
        }
        Arrays.sort(arr);
        int[] res = new int[queries.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < queries.length; i++) {
            int num = f(queries[i]);
            if (map.containsKey(num)) {
                res[i] = map.get(num);
                continue;
            }
            int x = 0;
            for (int j = arr.length - 1; j >= 0; j--) {
                if (arr[j] > num) {
                    x++;
                } else {
                    break;
                }
            }
            map.put(num, x);
            res[i] = x;
        }
        return res;
    }

    public int f(String str) {
        int[] arr = new int[26];
        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i) - 'a';
            arr[c] += 1;
        }
        for (int j : arr) {
            if (j != 0) {
                return j;
            }
        }
        return 0;
    }

    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        Map<Integer, ListNode> seen = new HashMap<>();
        int prefix = 0;
        for (ListNode node = dummy; node != null; node = node.next) {
            prefix += node.val;
            seen.put(prefix, node);
        }
        prefix = 0;
        for (ListNode node = dummy; node != null; node = node.next) {
            prefix += node.val;
            node.next = seen.get(prefix).next;
        }
        return dummy.next;
    }

    public int unequalTriplets(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] != nums[j] && nums[i] != nums[k] && nums[j] != nums[k]) {
                        num++;
                    }
                }
            }
        }
        return num;
    }

    public int numTimesAllBlue(int[] flips) {
        int[] arr = new int[flips.length];
        int num = 0;
        int max = 0;
        for (int i = 0; i < flips.length; i++) {
            int index = flips[i] - 1;
            max = Math.max(index, max);
            if (index == 0) {
                arr[index] = 2;
                if (index == max) {
                    num++;
                }
                for (int j = 1; j < arr.length; j++) {
                    if (arr[j] == 1) {
                        arr[j] = 2;
                        if (j == max) {
                            num++;
                        }
                    } else {
                        break;
                    }
                }
                continue;
            }
            if (arr[index - 1] == 1 || arr[index - 1] == 0) {
                arr[index] = 1;
            } else {
                arr[index] = 2;
                if (index == max) {
                    num++;
                }
                for (int j = index + 1; j < arr.length; j++) {
                    if (arr[j] == 1) {
                        arr[j] = 2;
                        if (j == max) {
                            num++;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return num;
    }

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> list = new ArrayList<>();
        c:
        for (int[] query : queries) {
            int num = query[1] - query[0] + 1;
            if (num / 2 <= query[2]) {
                list.add(true);
                continue;
            }
            int left = query[0];
            int right = query[1];
            Map<Character, Integer> map = new HashMap<>();
            for (int i = left; i <= right; i++) {
                map.merge(s.charAt(i), 1, Integer::sum);
                if (map.get(s.charAt(i)) % 2 == 0) {
                    map.remove(s.charAt(i));
                }
            }
            if (map.size() / 2 <= query[2]) {
                list.add(true);
            } else {
                list.add(false);
            }

        }
        return list;
    }

    public int numberOfCuts(int n) {
        if (n == 1) {
            return 0;
        }
        return n % 2 == 0 ? n / 2 : n / 2 + 1;
    }


    public void countWeather(){
        String[] cityS = {"漠河","沈阳","北京","广州","昆明"};
        Random random = new Random();
        int[] arr = new int[31];
        for (String city : cityS) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = random.nextInt(2);
            }
            int num = 0;
            int max = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 0) {
                    num++;
                }else {
                    max = Math.max(num,max);
                    num = 0;
                }
            }
            System.out.println(city+" 的天气为：" + Arrays.toString(arr));
            System.out.println(city+" 最大连续无降水天数：" + max);
        }
    }


    public static void main(String[] args) {
        Main main = new Main();
//        int[] arr = new int[]{2, 2, -2, 1, -1, -1};
//        ListNode head = new ListNode(arr[0]);
//        ListNode r = head;
//        for (int i = 1; i < arr.length; i++) {
//            r.next = new ListNode(arr[i]);
//            r = r.next;
//        }
//        main.removeZeroSumSublists(head);
//        int[] arr = new int[]{1, 2, 3, 4, 4, 5};
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int x : arr) {
//            map.merge(x, 1, Integer::sum);
//        }
//        System.out.println(map);
        main.countWeather();
    }

}
