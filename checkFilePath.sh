function check_path(){
 hdfs_path=$1
 hadoop fs -test -e ${hdfs_path}
 if [ $? -ne 0 ];then
     echo ${hdfs_path} "not exists"
        return 1
 else
     echo ${hdfs_path} "exists"
         return 0
 fi
}
check_path