SELECT * FROM nodes WHERE node_id IN(
SELECT target_id FROM edges WHERE edge_id IN(
SELECT node_id FROM nodes WHERE name = 'Odessa Satmary'));

SELECT * FROM nodes WHERE node_id IN(
SELECT target_id FROM edges WHERE edge_id IN(
SELECT target_id FROM edges WHERE edge_id IN(
SELECT node_id FROM nodes WHERE name = 'Odessa Satmary')));

SELECT * FROM nodes WHERE node_id IN(
SELECT target_id FROM edges WHERE edge_id IN(
SELECT target_id FROM edges WHERE edge_id IN(
SELECT target_id FROM edges WHERE edge_id IN(
SELECT node_id FROM nodes WHERE name = 'Odessa Satmary'))));

SELECT * FROM nodes WHERE node_id IN(
SELECT target_id FROM edges WHERE edge_id IN(
SELECT target_id FROM edges WHERE edge_id IN(
SELECT target_id FROM edges WHERE edge_id IN(
SELECT target_id FROM edges WHERE edge_id IN(
SELECT node_id FROM nodes WHERE name = 'Odessa Satmary')))));

SELECT * FROM nodes WHERE node_id IN(
SELECT target_id FROM edges WHERE edge_id IN(
SELECT target_id FROM edges WHERE edge_id IN(
SELECT target_id FROM edges WHERE edge_id IN(
SELECT target_id FROM edges WHERE edge_id IN(
SELECT target_id FROM edges WHERE edge_id IN(
SELECT node_id FROM nodes WHERE name = 'Odessa Satmary'))))));