set linesize 200
set term off verify off feedback off pagesize 999
set markup html on entmap ON spool on preformat off
spool C:\Users\84979\Documents\1.xls
select * from goods ;
spool off
exit