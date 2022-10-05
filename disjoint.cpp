#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#include <utility>
#include <unordered_map>
#define 100000 N

/*
1. findParent()
2. union() -> combine into single component, if they are two different component.
#Done By Unoin by rank and path compression.
*/

int parent[N];
int rank[N] void makeSet()
{
    for (int i = 0; i <= n; i++)
    {
        parent[i] = i;
        rank[i] = 0;
    }
}

int findParent(int node)
{
    if (node == parent[node])
        return node;

    return parent[node] = findParent(parent[node]);
}

void union(int v, int u)
{
    u = findParent(u);
    v = findParent(v);

    if (rank[u] < rank[v])
        parent[u] = v;
    else if (rank[v] < rank[u])
        parent[v] = u;
    else
    {
        parent[v] = u;
        rank[u]++;
    }
}

int main()
{
    makeSet();

    // if two nodes belog to different component or not.
    if (findParent(u) != findParent(v))
        cout << "Different Component";
    else
        cout << "Same Component";
}