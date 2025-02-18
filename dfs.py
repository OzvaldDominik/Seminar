def dfs_matrix(graph, start, visited=None):
    if visited is None:
        visited = set()

    visited.add(start)
    print(start, end=" ")

    for neighbor, connected in enumerate(graph[start]):
        if connected == 1 and neighbor not in visited:
            dfs_matrix(graph, neighbor, visited)


# Example usage
# Adjacency matrix for a graph with 4 nodes (0, 1, 2, 3)
graph = [[0, 1, 1, 0], [1, 0, 0, 1], [1, 0, 0, 1], [0, 1, 1, 0]]

print("DFS traversal starting from node 0:")
dfs_matrix(graph, 0)
