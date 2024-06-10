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

INSERT INTO repair_type_cost (repair_type, description, gasoline_cost, diesel_cost, hybrid_cost, electric_cost) VALUES
('Brake System Repairs', 'Includes replacing brake pads, discs, drums, brake lines, and repairing or replacing the brake master cylinder.', 120000, 120000, 180000, 220000),
('Cooling System Service', 'Repairing or replacing radiators, water pumps, thermostats, and hoses, as well as troubleshooting overheating issues.', 130000, 130000, 190000, 230000),
('Engine Repairs', 'From minor repairs like replacing spark plugs and wires, to major repairs like engine rebuilding or head gasket repair.', 350000, 450000, 700000, 800000),
('Transmission Repairs', 'Includes repairing or replacing components of the manual or automatic transmission, fluid changes, and troubleshooting gear shifting issues.', 210000, 210000, 300000, 300000),
('Electrical System Repair', 'Troubleshooting and repairing alternators, starters, batteries, and wiring systems, as well as repairing electrical components like headlights, turn signals, and entertainment systems.', 150000, 150000, 200000, 250000),
('Exhaust System Repairs', 'Includes replacing the muffler, exhaust pipes, catalytic converter, and troubleshooting emission-related issues.', 100000, 120000, 450000, 0),
('Tire and Wheel Repair', 'Repairing punctures, replacing tires, wheel alignment, and balancing.', 100000, 100000, 100000, 100000),
('Suspension and Steering Repairs', 'Replacing shocks, control arms, ball joints, and repairing the power steering system.', 180000, 180000, 210000, 250000),
('Air Conditioning and Heating System Repair', 'Includes refrigerant recharge, repairing or replacing the compressor, and troubleshooting heating system issues.', 150000, 150000, 180000, 180000),
( 'Fuel System Repairs', 'Cleaning or replacing fuel injectors, repairing or replacing the fuel pump, and troubleshooting fuel supply issues.', 130000, 140000, 220000, 0),
( 'Windshield and Glass Replacement', 'Repairing small cracks in the windshield or complete replacement of damaged windshields and windows.', 80000, 80000, 80000, 80000);