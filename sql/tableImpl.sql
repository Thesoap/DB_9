DROP TABLE IF EXISTS nodes;
DROP TABLE IF EXISTS edges;
CREATE TABLE nodes
(
	node_id INT,
    name VARCHAR(50),
    job VARCHAR(50),
    birthday DATE
);

CREATE TABLE edges
(
	edge_id INT,
    target_id INT
);
LOAD DATA LOCAL INFILE 'C:/Users/micha/Desktop/skolearbejde/soft/database/Assignment 9 - Database Comparison/social_network_nodes.csv'
INTO TABLE nodes
FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 LINES
(node_id,name,job,birthday)
;

LOAD DATA LOCAL INFILE 'C:/Users/micha/Desktop/skolearbejde/soft/database/Assignment 9 - Database Comparison/social_network_edges.csv'
INTO TABLE edges
FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 LINES
(edge_id,target_id)
;