SELECT dht_id, COUNT(*) as Counts
FROM photo
GROUP BY dht_id
order by Counts desc;