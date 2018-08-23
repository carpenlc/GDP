/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mil.nga.egmc;

/**
 *
 * @author koblentm
 */
public class product {

    private String name;
    private String type;
    private String table;
    private String aor_table;
    private String query;
    private String cd_column;
    private String frame_column;
    private String description;
    private String imgType;
    private int maxDownloadRec;

    public product()
    {
        this.name = "";
        this.type = "";
        this.table = "";
        this.aor_table = "";
        this.query = "";
        this.cd_column ="";
        this.frame_column = "";
        this.description = "";
        this.imgType = "";
        this.maxDownloadRec = 0;
    }
    public product(String name, String type, String table, String aor_table, String query, String cd_column, String frame_column,
            String description, String imgType, String imgFormats, int maxDownloadRec)
    {
        this.name = name;
        this.type = type;
        this.table = table;
        this.aor_table = aor_table;
        this.query = query;
        this.cd_column =cd_column;
        this.frame_column = frame_column;
        this.description = description;
        this.imgType = imgType;
        this.maxDownloadRec = maxDownloadRec;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    public void setType(String type)
    {
        this.type = type;
    }
    public void setTable(String table)
    {
        this.table = table;
    }
    public void setAorTable(String aor_table)
    {
        this.aor_table = aor_table;
    }
    public void setQuery(String query)
    {
        this.query = query;
    }
    public void setCdColumn(String cd_column)
    {
        this.cd_column = cd_column;
    }
    public void setFrameColumn(String frame_column)
    {
        this.frame_column = frame_column;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }
    public void setImgType(String imgType)
    {
        this.imgType = imgType;
    }
    public void setMaxDownloadRec(int maxDownloadRec)
    {
        this.maxDownloadRec = maxDownloadRec;
    }
    public String getName()
    {
        return this.name;
    }
     public String getType()
    {
        return this.type;
    }
    public String getTable()
    {
        return this.table;
    }
    public String getAorTable()
    {
        return this.aor_table;
    }
    public String getQuery()
    {
        return this.query;
    }
    public String getCdColumn()
    {
        return this.cd_column;
    }
    public String getFrameColumn()
    {
        return this.frame_column;
    }
    public String getDescription()
    {
        return this.description;
    }
    public String getImgType()
    {
        return this.imgType;
    }
    public int getMaxDownloadRec()
    {
        return this.maxDownloadRec;
    }

    @Override public String toString()
    {
        String temp = "Name: "+ this.name + "\n";
        temp = temp + "Type: " + this.type + "\n";
        temp = temp + "Table: " + this.table + "\n";
        temp = temp + "AOR Table: " + this.aor_table + "\n";
        temp = temp + "Query: " + this.query + "\n";
        temp = temp + "Cd Column: " + this.cd_column + "\n";
        temp = temp + "Frame Column: " + this.frame_column + "\n";
        temp = temp + "Description: " + this.description + "\n";
        temp = temp + "Image Type: " + this.imgType + "\n";
        temp = temp + "Image Download Limit:  " + this.maxDownloadRec + "\n";
        return temp;
    }

}