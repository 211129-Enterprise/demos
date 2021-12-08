select * from "Artist";
select * from "Album";


-- inner join
create view simple_artist_view as
select album."AlbumId", album."Title", art."Name" as artist
    from "Album" album 
    join "Artist" art 
    on album."ArtistId" = art."ArtistId";
    
select * from simple_album_artist_view;

-- natural join
select album."AlbumId", album."Title", art."Name" as artist
    from "Album" album 
    natural join "Artist" art
    where("ArtistId");
    
select * from "Employee";

select e1."FirstName", e1."Title", e2."FirstName" as boss_firstName, e2."Title" as boss_title
    from "Employee" e1
    join "Employee" e2
    on e1."ReportsTo" = e2."EmployeeId";
    
select * from "Track";
select * from "InvoiceLine";

select t."TrackId", t."Name", il."UnitPrice"
    from "Track" t 
    left join "InvoiceLine" il 
    on t."TrackId" = il."TrackId";
