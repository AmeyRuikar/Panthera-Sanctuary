
--create table, index for Lions
create table lionTable(lionID varchar2(4) NOT NULL, location MDSYS.SDO_GEOMETRY);


insert into lionTable values('L14',SDO_GEOMETRY(2001,NULL,SDO_POINT_TYPE(350,50,NULL),NULL,NULL));

insert into lionTable values('L10',SDO_GEOMETRY(2001,NULL,SDO_POINT_TYPE(355,190,NULL),NULL,NULL));

insert into lionTable values('L11',SDO_GEOMETRY(2001,NULL,SDO_POINT_TYPE(30,210,NULL),NULL,NULL));

insert into lionTable values('L12',SDO_GEOMETRY(2001,NULL,SDO_POINT_TYPE(50,200,NULL),NULL,NULL));

insert into lionTable values('L13',SDO_GEOMETRY(2001,NULL,SDO_POINT_TYPE(170,230,NULL),NULL,NULL));

insert into lionTable values('L6',SDO_GEOMETRY(2001,NULL,SDO_POINT_TYPE(350,300,NULL),NULL,NULL));



insert into lionTable values('L7',SDO_GEOMETRY(2001,NULL,SDO_POINT_TYPE(35,10,NULL),NULL,NULL));

insert into lionTable values('L4',SDO_GEOMETRY(2001,NULL,SDO_POINT_TYPE(450,300,NULL),NULL,NULL));


insert into lionTable values('L5',SDO_GEOMETRY(2001,NULL,SDO_POINT_TYPE(20,20,NULL),NULL,NULL));

insert into liontable values('L2',SDO_GEOMETRY(2001,NULL,SDO_POINT_TYPE(230,475,NULL),NULL,NULL));


insert into lionTable values('L3',SDO_GEOMETRY(2001,NULL,SDO_POINT_TYPE(370,455,NULL),NULL,NULL));

insert into lionTable values('L1',SDO_GEOMETRY(2001,NULL,SDO_POINT_TYPE(50,450,NULL),NULL,NULL));


insert into lionTable values('L8',SDO_GEOMETRY(2001,NULL,SDO_POINT_TYPE(115,350,NULL),NULL,NULL));

insert into lionTable values('L9',SDO_GEOMETRY(2001,NULL,SDO_POINT_TYPE(240,335,NULL),NULL,NULL));

commit;

insert into user_sdo_geom_metadata values('lionTable','location',SDO_DIM_ARRAY(
SDO_DIM_ELEMENT('X','0','550','0.005'),SDO_DIM_ELEMENT('Y','0','550','0.005')),NULL);

create index lionTableIndex on liontable(location) indextype is MDSYS.SPATIAL_INDEX;

--end of lion Table.

--create table, index for regions

create table regionTable(regionID varchar2(4) NOT NULL, vertices number, co_ordinates MDSYS.SDO_GEOMETRY);

insert into regionTable values('R4', 4,SDO_GEOMETRY(2003,NULL,NULL,
SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY(400,0, 500,0, 500,100, 400,100, 400,0)));

insert into regionTable values('R5', 4,SDO_GEOMETRY(2003,NULL,NULL,
SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY(400,100, 500,100, 500,250, 400,200, 400,100)));

insert into regionTable values('R6', 4,SDO_GEOMETRY(2003,NULL,NULL,
SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY(300,150, 400,100, 400,200, 250,250, 300,150)));


insert into regionTable values('R7', 4,SDO_GEOMETRY(2003,NULL,NULL,
SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY(100,100, 300,150, 250,250, 150,250, 100,100)));


insert into regionTable values('R12', 4,SDO_GEOMETRY(2003,NULL,NULL,
SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY(400,200, 500,250, 500,350, 400,350, 400,200)));

insert into regionTable values('R1', 4,SDO_GEOMETRY(2003,NULL,NULL,
SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY(0,0, 150,0, 100,100, 0,100, 0,0)));

insert into regionTable values('R2', 4,SDO_GEOMETRY(2003,NULL,NULL,
SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY(150,0, 250,0, 300,150, 100,100, 150,0)));

insert into regionTable values('R3', 4,SDO_GEOMETRY(2003,NULL,NULL,
SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY(250,0, 400,0, 400,100, 300,150, 250,0)));

insert into regionTable values('R11', 4,SDO_GEOMETRY(2003,NULL,NULL,
SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY(250,250, 400,200, 400,350, 300,350, 250,250)));

insert into regionTable values('R8', 4,SDO_GEOMETRY(2003,NULL,NULL,
SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY(0,100, 100,100, 150,250 ,0,250, 0,100)));


insert into regionTable values('R9', 4,SDO_GEOMETRY(2003,NULL,NULL,
SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY(0,250, 150,250, 150,400, 0,350, 0,250)));


insert into regionTable values('R10', 4,SDO_GEOMETRY(2003,NULL,NULL,
SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY(150,250, 250,250, 300,350, 150,400, 150,250)));


insert into regionTable values('R15', 4,SDO_GEOMETRY(2003,NULL,NULL,
SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY(150,400, 300,350, 300,500, 150,500, 150,400)));

insert into regionTable values('R14', 4,SDO_GEOMETRY(2003,NULL,NULL,
SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY(300,350, 400,350, 400,500, 300,500, 300,350)));


insert into regionTable values('R16', 4,SDO_GEOMETRY(2003,NULL,NULL,
SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY(0,350,150,400,150,500,0,500,0,350)));


insert into regionTable values('R13', 4,SDO_GEOMETRY(2003,NULL,NULL,
SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY(400,350,500,350,500,500,400,500,400,350)));



insert into user_sdo_geom_metadata values('regionTable','co_ordinates',
SDO_DIM_ARRAY(SDO_DIM_ELEMENT('X','0','550','0.005'),SDO_DIM_ELEMENT('Y','0','550','0.005')),NULL);

commit;

create index regionTableIndex on regionTable(co_ordinates) indextype is MDSYS.SPATIAL_INDEX;

--end of region table

--create table, index for ponds
create table pondTable(pondID varchar2(4) NOT NULL, area MDSYS.SDO_GEOMETRY);

insert into pondTable values('P2',SDO_GEOMETRY(2003,NULL,NULL,SDO_ELEM_INFO_ARRAY(1,1003,4),
SDO_ORDINATE_ARRAY(220,415,205,430 ,220,445)));

insert into pondTable values('P3',SDO_GEOMETRY(2003,NULL,NULL,SDO_ELEM_INFO_ARRAY(1,1003,4),
SDO_ORDINATE_ARRAY(370,420,385,435,370,450)));

insert into pondTable values('P1',SDO_GEOMETRY(2003,NULL,NULL,SDO_ELEM_INFO_ARRAY(1,1003,4),
SDO_ORDINATE_ARRAY(75,415,90,430,75,445)));

insert into pondTable values('P6',SDO_GEOMETRY(2003,NULL,NULL,SDO_ELEM_INFO_ARRAY(1,1003,4),
SDO_ORDINATE_ARRAY(220,305,235,320,220,335)));




insert into pondTable values('P7',SDO_GEOMETRY(2003,NULL,NULL,SDO_ELEM_INFO_ARRAY(1,1003,4),
SDO_ORDINATE_ARRAY(470,295,485,280, 470,265)));

insert into pondTable values('P4',SDO_GEOMETRY(2003,NULL,NULL,SDO_ELEM_INFO_ARRAY(1,1003,4),
SDO_ORDINATE_ARRAY(75,315,90,330,75,345)));

insert into pondtable values('P5',SDO_GEOMETRY(2003,NULL,NULL,SDO_ELEM_INFO_ARRAY(1,1003,4),
SDO_ORDINATE_ARRAY(320,265,335,280,320,295)));

insert into pondTable values('P8',SDO_GEOMETRY(2003,NULL,NULL,SDO_ELEM_INFO_ARRAY(1,1003,4),
SDO_ORDINATE_ARRAY(375,160,390,175,375,190)));

insert into user_sdo_geom_metadata values('pondTable','area',
SDO_DIM_ARRAY(SDO_DIM_ELEMENT('X','0','550','0.005'),SDO_DIM_ELEMENT('Y','0','550','0.005')),NULL);

commit;


create index pondTableIndex on pondTable(area) indextype is MDSYS.SPATIAL_INDEX;

--end of ponds table

--create table, index for ambulance

create table ambulanceTable(ambulanceID varchar2(3), range MDSYS.SDO_GEOMETRY);

insert into ambulanceTable values('A1',SDO_GEOMETRY(2003,NULL,NULL,
                                       SDO_ELEM_INFO_ARRAY(1,1003,4),
                                       SDO_ORDINATE_ARRAY(100,310,190,400,100,490)));


insert into ambulanceTable values('A3',SDO_GEOMETRY(2003,NULL,NULL,SDO_ELEM_INFO_ARRAY(1,1003,4),
SDO_ORDINATE_ARRAY(400,310,490,400,400,490)));



insert into ambulanceTable values('A2',SDO_GEOMETRY(2003,NULL,NULL,SDO_ELEM_INFO_ARRAY(1,1003,4),
SDO_ORDINATE_ARRAY( 340,400,250,310,250,490)));

insert into ambulanceTable values('A5',SDO_GEOMETRY(2003,NULL,NULL,SDO_ELEM_INFO_ARRAY(1,1003,4),
SDO_ORDINATE_ARRAY(300,10,390,100,300,190)));

insert into ambulanceTable values('A4',SDO_GEOMETRY(2003,NULL,NULL,SDO_ELEM_INFO_ARRAY(1,1003,4),
SDO_ORDINATE_ARRAY(400,160,490,250,400,340)));



insert into user_sdo_geom_metadata values('ambulanceTable','range',
SDO_DIM_ARRAY(SDO_DIM_ELEMENT('X','0','550','0.005'),SDO_DIM_ELEMENT('Y','0','550','0.005')),NULL);

commit;

create index ambulanceTableIndex on ambulanceTable(range) indextype is MDSYS.SPATIAL_INDEX;
--end of ambulance table
commit;