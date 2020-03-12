declare variable $authorName as xs:string external;
declare variable $authorYear as xs:string external;
for $x in doc("dblp-soc-papers-V2.xml")/dblp/article[author=$authorName and year=$authorYear]
return $x/title/text()