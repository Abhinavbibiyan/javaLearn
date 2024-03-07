package Graphs;

import java.util.*;

class disjoint {
	int n;
	int parent[];
	int rank[];

	disjoint(int n) {
		this.n = n;
		parent = new int[n + 1];
		rank = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			parent[i] = i;
		}
	}

	public int find(int n) {
		if (parent[n] == n)
			return n;
		return parent[n] = find(parent[n]);
	}

	public void union(int s, int d) {
		int sp = find(s);
		int dp = find(d);
		if (sp == dp) {
			return;
		}
		if (rank[sp] < rank[dp]) {
			parent[sp] = dp;
		} else if (rank[dp] < rank[sp]) {
			parent[dp] = sp;
		} else {
			parent[sp] = dp;
			rank[dp]++;
		}
	}

}

public class mergeAccount {
	static List<List<String>> accountsMerge(List<List<String>> accounts) {
		int n = accounts.size();
		disjoint dis = new disjoint(n);
		HashMap<String, Integer> mapNodeMail = new HashMap<>();
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < accounts.get(i).size(); j++) {
				if (mapNodeMail.containsKey(accounts.get(i).get(j)) == false) {
					mapNodeMail.put(accounts.get(i).get(j), i);
				} else {
					dis.union(i, mapNodeMail.get(accounts.get(i).get(j)));
				}
			}
		}
		ArrayList<String> merg[] = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			merg[i] = new ArrayList<>();
		}
		for (Map.Entry<String, Integer> mails : mapNodeMail.entrySet()) {
			String mail = mails.getKey();
			int node = dis.find(mails.getValue());
			merg[node].add(mail);
		}
		List<List<String>> ans = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (merg[i].size() == 0)
				continue;
			Collections.sort(merg[i]);
			List<String> temp = new ArrayList<>();
			temp.add(accounts.get(i).get(0));
			for (String it : merg[i]) {
				temp.add(it);
			}
			ans.add(temp);
		}
		return ans;
	}

	public static void main(String[] args) {
		List<List<String>> accounts = new ArrayList();
		accounts.add(new ArrayList<String>(Arrays.asList("John", "j1@com", "j2@com", "j3@com")));
		accounts.add(new ArrayList<String>(Arrays.asList("John", "j4@com")));
		accounts.add(new ArrayList<String>(Arrays.asList("Raj", "r1@com", "r2@com")));
		accounts.add(new ArrayList<String>(Arrays.asList("John", "j1@com", "j5@com")));
		accounts.add(new ArrayList<String>(Arrays.asList("Raj", "r2@com", "r3@com")));
		accounts.add(new ArrayList<String>(Arrays.asList("Mary", "m1@com")));

		List<List<String>> ans = accountsMerge(accounts);
		int n = ans.size();
		for (int i = 0; i < n; i++) {
			System.out.print(ans.get(i).get(0) + ": ");
			int size = ans.get(i).size();
			for (int j = 1; j < size; j++) {
				System.out.print(ans.get(i).get(j) + " ");
			}

			System.out.println("");
		}
	}
}
