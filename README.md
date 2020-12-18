# track-status-enrollee
To setup this project locally, please follow below steps.
1. Download this code then import into your favorite IDE.
2. Used MySQL db, please use below script to create table.

  DROP TABLE IF EXISTS "healthms"."enrollee";
CREATE TABLE  "healthms"."enrollee" (
  "id" int(10) unsigned NOT NULL AUTO_INCREMENT,
  "name" varchar(45) NOT NULL DEFAULT '',
  "status" tinyint(1) NOT NULL DEFAULT '0',
  "phone_no" bigint(20) unsigned DEFAULT NULL,
  "primary_enrolle_id" int(10) unsigned DEFAULT NULL,
  "birth_date" date NOT NULL DEFAULT '0000-00-00',
  PRIMARY KEY ("id"),
  KEY "FK_enrollee_1" ("primary_enrolle_id"),
  CONSTRAINT "FK_enrollee_1" FOREIGN KEY ("primary_enrolle_id") REFERENCES "enrollee" ("id")
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

3. Used username and password for MySQL as 'root' and 'root'
4. Build spring boot application
5. Start as java application
6. Used port number as '9000'
7. Here is swagger URL: http://localhost:9000//swagger-ui.html
