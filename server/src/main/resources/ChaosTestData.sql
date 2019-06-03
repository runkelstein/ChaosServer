insert into chaosList(`name`) values( 'Frauen ansprechen');
set @listidx = SELECT MAX(rownum)  from (SELECT ROWNUM() FROM chaosList);
insert into chaositem(`done`,`content`,`chaoslist`) values (0, 'Anlächeln', @listidx);
insert into chaositem(`done`,`content`,`chaoslist`) values (0, 'Wenn Frau zurück lächelt', @listidx);
set @itemIdx = SELECT MAX(rownum)  from (SELECT ROWNUM() FROM chaositem);
insert into chaositem(`done`,`content`,`chaoslist`, `chaositem`) values (0, 'Auf Frau zugehen', @listidx,  @itemIdx);
insert into chaositem(`done`,`content`,`chaoslist`, `chaositem`) values (0, 'Begrüßen', @listidx,  @itemIdx);