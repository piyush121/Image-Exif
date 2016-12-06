select distinct model_name as Model, GROUP_CONCAT(dht_code SEPARATOR ', ') as Huffman_Codes from model, huffman, photo 
where photo.dht_id = huffman.dht_id and photo.ifd0_Model = model.model_id 
group by model_name
order by model_name desc
limit 200;