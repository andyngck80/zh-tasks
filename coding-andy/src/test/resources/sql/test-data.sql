INSERT INTO electric_consumer (id, village_name)
VALUES
  (1000, 'Ramsau'),
  (2000, 'Miltenberg');

INSERT INTO electric_consumption (
  id, consumer_id, consumption, created_date_time)
VALUES
  (100, 1000, 10000.1, current_timestamp - 2 hour),
  (101, 1000, 20000.02, current_timestamp - 2 hour),
  (102, 1000, 30000.3, current_timestamp - 30 hour),
  (103, 2000, 40000.004, current_timestamp - 2 hour);
