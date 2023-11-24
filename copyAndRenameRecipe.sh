path=$1
oldName=$2
newName=$3
newFolderName=$4

filter=${f//$oldName/$newName}

cd $path

for f in *
do
  if [[ "$f" == *"$oldName"* ]]
  then
    cp $f ../$newFolderName/${f//$oldName/$newName}
  fi
done

#cd ../$newFolderName
#for file in *
#do
#  sed -i '' 's/$oldName/$newName/g' $file
#done

echo "Copied all files"
