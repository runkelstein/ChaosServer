delete from chaosList;

insert into chaosList(`name`,`doc`) values( 'Simple List','title: Simple List');
insert into chaosList(`name`,`doc`) values( 'Simple List 2','title: Simple List 2');
insert into chaosList(`name`,`doc`) values( 'Frauen ansprechen','title: Frauen ansprechen');

insert into chaosList(`name`, `doc`) values('Simple List 3',
concat_ws(CHAR(10),'title: Simple List 3',
'items:',
'  - type: text',
'    level: 0',
'    content: ipsum lorem',
'    bold: normal',
'    italic: normal',
'  - type: h1',
'    level: 0',
'    content: ipsum lorem',
'  - type: image',
'    level: 0',
'    path: recipe.png',
'    items:',
'      - type: bullet',
'        level: 1',
'        content: ipsum lorem',
'      - type: enumeration',
'        level: 2',
'        content: first entry',
'        items:',
'          - type: enumeration',
'            level: 3',
'            content: "1.1"',
'      - type: enumeration',
'        level: 2',
'        content: second entry',
'        items:',
'          - type: enumeration',
'            level: 3',
'            content: "2.1"'
));