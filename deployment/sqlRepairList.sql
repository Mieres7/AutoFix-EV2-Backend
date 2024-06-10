INSERT INTO repair_discount (repair_discount_id, gasoline_cost, diesel_cost, hybrid_cost, electric_cost) VALUES
(1, 0.05, 0.07, 0.10, 0.08),
(2, 0.10, 0.12, 0.15, 0.13),
(3, 0.15, 0.17, 0.20, 0.18),
(4, 0.20, 0.22, 0.25, 0.23);

INSERT INTO age_charge (age_charge_id, sedan_charge, hatchback_charge, suv_charge, pickup_charge, van_charge) VALUES
(1, 0.00, 0.00, 0.00, 0.00, 0.00),
(2, 0.05, 0.05, 0.07, 0.07, 0.07),
(3, 0.09, 0.09, 0.11, 0.11, 0.11),
(4, 0.15, 0.15, 0.20, 0.20, 0.20);

INSERT INTO kilometer_charge (kilometer_charge_id, sedan_charge, hatchback_charge, suv_charge, pickup_charge, van_charge) VALUES
(1, 0.00, 0.00, 0.00, 0.00, 0.00),
(2, 0.03, 0.03, 0.05, 0.05, 0.05),
(3, 0.07, 0.07, 0.09, 0.09, 0.09),
(4, 0.12, 0.12, 0.12, 0.12, 0.12),
(5, 0.20, 0.20, 0.20, 0.20, 0.20);

INSERT INTO repair_type_cost (repair_type_cost_id, repair_type, description, gasoline_cost, diesel_cost, hybrid_cost, electric_cost) VALUES
(1, 'Brake System Repairs', 'Includes replacing brake pads, discs, drums, brake lines, and repairing or replacing the brake master cylinder.', 120000, 120000, 180000, 220000),
(2, 'Cooling System Service', 'Repairing or replacing radiators, water pumps, thermostats, and hoses, as well as troubleshooting overheating issues.', 130000, 130000, 190000, 230000),
(3, 'Engine Repairs', 'From minor repairs like replacing spark plugs and wires, to major repairs like engine rebuilding or head gasket repair.', 350000, 450000, 700000, 800000),
(4, 'Transmission Repairs', 'Includes repairing or replacing components of the manual or automatic transmission, fluid changes, and troubleshooting gear shifting issues.', 210000, 210000, 300000, 300000),
(5, 'Electrical System Repair', 'Troubleshooting and repairing alternators, starters, batteries, and wiring systems, as well as repairing electrical components like headlights, turn signals, and entertainment systems.', 150000, 150000, 200000, 250000),
(6, 'Exhaust System Repairs', 'Includes replacing the muffler, exhaust pipes, catalytic converter, and troubleshooting emission-related issues.', 100000, 120000, 450000, 0),
(7, 'Tire and Wheel Repair', 'Repairing punctures, replacing tires, wheel alignment, and balancing.', 100000, 100000, 100000, 100000),
(8, 'Suspension and Steering Repairs', 'Replacing shocks, control arms, ball joints, and repairing the power steering system.', 180000, 180000, 210000, 250000),
(9, 'Air Conditioning and Heating System Repair', 'Includes refrigerant recharge, repairing or replacing the compressor, and troubleshooting heating system issues.', 150000, 150000, 180000, 180000),
(10, 'Fuel System Repairs', 'Cleaning or replacing fuel injectors, repairing or replacing the fuel pump, and troubleshooting fuel supply issues.', 130000, 140000, 220000, 0),
(11, 'Windshield and Glass Replacement', 'Repairing small cracks in the windshield or complete replacement of damaged windshields and windows.', 80000, 80000, 80000, 80000);

INSERT INTO report (repair_type_name, month, year, sedan, sedan_amount, hatchback, hatchback_amount, pickup, pickup_amount, suv, suv_amount, van, van_amount) VALUES
('Brake System Repairs', '12', '2023', 4, 480000, 5, 240000, 6, 360000, 3, 120000, 2, 240000),
('Brake System Repairs', '01', '2024', 7, 360000, 8, 120000, 5, 240000, 6, 360000, 4, 480000),
('Brake System Repairs', '02', '2024', 6, 240000, 7, 360000, 3, 480000, 5, 120000, 8, 240000),
('Brake System Repairs', '03', '2024', 9, 360000, 3, 120000, 7, 240000, 4, 480000, 6, 360000),
('Brake System Repairs', '04', '2024', 8, 120000, 5, 480000, 2, 360000, 9, 240000, 7, 360000),
('Cooling System Service', '12', '2023', 3, 420000, 4, 300000, 5, 360000, 6, 240000, 7, 180000),
('Cooling System Service', '01', '2024', 6, 360000, 7, 150000, 4, 300000, 5, 420000, 3, 480000),
('Cooling System Service', '02', '2024', 5, 300000, 6, 420000, 7, 480000, 4, 150000, 2, 240000),
('Cooling System Service', '03', '2024', 8, 360000, 2, 150000, 6, 300000, 5, 480000, 3, 420000),
('Cooling System Service', '04', '2024', 7, 150000, 5, 480000, 3, 360000, 6, 240000, 4, 420000);


