create schema DB_RETO_5_Paciente;
USE DB_RETO_5_Paciente;

create table paciente(
	pac_cedula int(11) not null primary key,
    pac_apellido char(30) null,
    pac_nombre char(30) null,
    pac_genero char(1) null,
    pac_edad int(11)
);

insert into paciente values (1112482728,"Rada","Jennifer","F",19);
insert into paciente values (31322858,"Albán","Elissa","F",35);
insert into paciente values (1144182152,"Losada","Stephania","F",22);
insert into paciente values (1144138193,"Prado","Johathan","M",23);
insert into paciente values (1130679339,"Osorio","Yimy","F",25);
insert into paciente values (67018365,"Cortes","Jhon","M",38);
insert into paciente values (1059448353,"Arcila","Angélica","F",21);
insert into paciente values (1144128511,"Bustamante","Eliana","F",24);
insert into paciente values (1130643373,"Montaño","Robert","M",23);
insert into paciente values (38680509,"Osorio","Juan","M",54);
insert into paciente values (1107074369,"Cruz","David","M",23);
insert into paciente values (1143841231,"Murillo","Julieth","F",24);

