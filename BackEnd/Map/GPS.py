import networkx as nx
import osmnx as ox
import json
from statistics import mean
import matplotlib.pyplot as plt

KmToMilesConversion = 0.62137273664981
coords = [20.123123, 10.12312]
coords2 = [20.123123, 10.12312]
coords3 = [20.123123, 10.12312]
G = ox.load_graphml("OSM.graphml")
# G = ox.graph_from_place("Liverpool, United kingdom", simplify=False, network_type="drive")
#hwy_speeds = {"residential": 15, "secondary": 30, "tertiary": 40}
G = ox.add_edge_speeds(G)
G = ox.add_edge_travel_times(G)
#ox.save_graphml(G, "OSM.graphml")
# coor = ox.geocode("EX18 7AX")
# print(coor)
# basic_stats = ox.basic_stats(G)
# print(basic_stats['circuity_avg'])
node = ox.nearest_nodes(G, coords3[1], coords3[0])
post = ox.geocode("post code")
print(post)

node2 = ox.nearest_nodes(G, coords2[1], coords2[0])
# route = nx.shortest_path(G, node2, node)
# #ox.plot.plot_graph_route(G,route)
# edge_lengths = ox.utils_graph.route_to_gdf(
#     G, route, 'length')['length']
# total_route_length = sum(edge_lengths)
# print("Total route length in km:", (total_route_length/1000) * KmToMilesConversion)
# edge_travel_time = ox.utils_graph.route_to_gdf(
#     G, route, 'travel_time')['travel_time']
# route_travel_time = mean(edge_travel_time) * len(edge_travel_time)
# print("Travel time in minutes:", route_travel_time/60)

#
# show edge attributes
edge = ox.nearest_edges(G, coords3[1], coords3[0])
print(edge)
edge_data = G.get_edge_data(edge[0], edge[1])
for edge_data in G.out_edges(node, data=True):
    print("\n=== Edge ====")
    print("Source and target node ID:", edge_data[:2])
    edge_attributes = edge_data[2]
    # remove geometry object from output
    #edge_attributes_wo_geometry = {i:edge_attributes[i] for i in edge_attributes if i!='geometry'}
    print("Edge attributes:", json.dumps(edge_attributes, indent=4))