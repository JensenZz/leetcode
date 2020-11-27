function check_partition(){
 table=$1
 partition=$2
 echo "${table}  partiton: ${partition}"
 temp=`hive -e "describe formatted ${table} partition(${partition}) " | grep "Location" | awk '{print $2}' `
 echo ${temp}
 if [[ ${temp} == '' ]]; then
  echo "$1 partition($2) not found"
  return 1
 else
  echo "$1 partition($2) found"
 fi

 location=${temp}
 echo "find location: ${location}"

 # 检查分区路径是否存在
 hdfs dfs -test -e  ${location}
 if [ $? -eq 0 ]; then
  echo "${location} exist."
 else
    echo "${location} not exist."
    return 1
 fi


 # 检查文件内容是否为空
 temp=` hadoop fs -ls ${location} | awk '{print $5}'`
 total=0
 # 默认1M
 defaultTotal=1048576
 for size in ${temp}
 do
    total=$((total + size))
    #echo "-------${size}   ${total}--------"
 done

 if [ ${total} -lt ${defaultTotal} ]; then
    echo "file size: ${total}, less than ${defaultTotal}"
    return 1
 fi

 return 0
}
check_partition